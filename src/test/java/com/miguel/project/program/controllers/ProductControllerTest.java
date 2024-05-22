package com.miguel.project.program.controllers;

import static org.mockito.ArgumentMatchers.any;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.miguel.project.program.entities.dto.ProductDTO;
import com.miguel.project.program.exceptions.EntityNotFoundException;
import com.miguel.project.program.services.ProductService;

@WebMvcTest(ProductController.class)
class ProductControllerTest {
    
    @Autowired
    private MockMvc mock;

    @MockBean
    private ProductService service;

    private Long validId;
    private Long invalidId;

    @BeforeEach
    void setup() {

        Long validId = 1L;
        invalidId = 99L;

        var productDTO = new ProductDTO("Product Test", 
            "Product Test Description", 
            BigDecimal.TEN, 
            "imageurl.com", 
            Instant.now());

        var pageImpl = new PageImpl<>(List.of(productDTO));

        Mockito.when(service.findAll(any())).thenReturn(pageImpl);

        Mockito.when(service.findById(validId)).thenReturn(productDTO);

        Mockito.when(service.findById(invalidId)).thenThrow(EntityNotFoundException.class);
    }

    @Test
    void shouldReturnOkStatusWhenGetAllMethodCalled() throws Exception {
        
        mock.perform(MockMvcRequestBuilders.get("/v1/products"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldReturnOkStatusWhenFindByIdMethodCalled() throws Exception {

        mock.perform(MockMvcRequestBuilders.get("/v1/products/" + invalidId))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldReturnNotFoundStatusWhenIdDoesNotExists() throws Exception {

        mock.perform(MockMvcRequestBuilders.get("/v1/products/{id}", invalidId))
            .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}