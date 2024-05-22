package com.miguel.project.program.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.miguel.project.program.exceptions.EntityNotFoundException;
import com.miguel.project.program.repositories.ProductRepository;

@ExtendWith(SpringExtension.class)
class ProductServiceTest {
    
    @InjectMocks
    private ProductService service;

    @Mock
    private ProductRepository repository;

    private Long validId;

    private Long invalidId;


    @BeforeEach
    void setup() {
        validId = 1L;

        invalidId = 99L;

        Mockito.doNothing().when(repository).deleteById(invalidId);

        Mockito.when(repository.existsById(invalidId)).thenReturn(false);
    }

    @Test
    void deleteShouldDoNothingWhenIdExists() {

        Assertions.assertDoesNotThrow(() -> {

            service.delete(validId);
        });
        
        Mockito.verify(repository).deleteById(validId);
    }

    @Test 
    void deleteShouldThrowEntityNotFoundWhenIdNotExists() {

        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            service.delete(invalidId);
        });
    }
}
