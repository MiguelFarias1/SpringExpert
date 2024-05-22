package com.miguel.project.program.repositories;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.miguel.project.program.entities.Category;
import com.miguel.project.program.entities.Product;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class ProductRepositoryTest {
     
    @Autowired
    private ProductRepository repository;

    private Long validId;

    private Long invalidID;


    @BeforeEach
    void setup() {
        validId = 1L;
        invalidID = 99L;
    }

    @Test
    void shouldDeleteObjectWhenIdExists() {

        Long id = 1L;

        repository.deleteById(id);

        var product = repository.findById(id);

        Assertions.assertFalse(product.isPresent());
    }

    @Test
    void shouldCreateProduct() {

        var product = new Product(null, "Product Title Test", 
                "Testing insert", BigDecimal.valueOf(500),
                "test.com", Instant.now(), new HashSet<>());

        product.getCategories().add(new Category(4l, "History", Instant.now(), null));
        
        product = repository.save(product);

        Assertions.assertNotNull(product.getId());

        Assertions.assertEquals(18L, product.getId());
    }

    @Test
    void shouldThrowExceptionWhenIdNotExists() {

        Assertions.assertThrows(jakarta.persistence.EntityNotFoundException.class,
             () -> repository.findById(invalidID).orElseThrow(() -> new jakarta.persistence.EntityNotFoundException()));
    }
}
