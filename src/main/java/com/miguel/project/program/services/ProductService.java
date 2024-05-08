package com.miguel.project.program.services;

import com.miguel.project.program.entities.Product;
import com.miguel.project.program.entities.dto.ProductDTO;
import com.miguel.project.program.exceptions.EntityNotFoundException;
import com.miguel.project.program.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        return productRepository
                .findAll(pageable)
                .map(ProductDTO::new);
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        return productRepository
                .findById(id)
                .map(ProductDTO::new)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }

    public ProductDTO save(ProductDTO productDTO) {

        var product = new Product(productDTO);

        productRepository.save(product);

        return productDTO;
    }
}
