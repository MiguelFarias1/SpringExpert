package com.miguel.project.program.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miguel.project.program.entities.Product;
import com.miguel.project.program.entities.dto.ProductDTO;
import com.miguel.project.program.exceptions.EntityNotFoundException;
import com.miguel.project.program.repositories.ProductRepository;

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

    private void updateData(Product destiny, ProductDTO source) {

        destiny.setName(source.getName());
        destiny.setPrice(source.getPrice());
        destiny.setDescription(source.getDescription());
    }

    public Product update(Long id, ProductDTO productDTO) {

        var product = productRepository.getReferenceById(id);

        if(product == null)
            throw new EntityNotFoundException("Product with id " + id + " not found!");

        else
            updateData(product, productDTO);

        return productRepository.save(product);

    }

    public void delete(Long id) {

        if (!productRepository.existsById(id))
            throw new EntityNotFoundException("category with id " + id + " not found");

        else
            productRepository.deleteById(id);
    }
}
