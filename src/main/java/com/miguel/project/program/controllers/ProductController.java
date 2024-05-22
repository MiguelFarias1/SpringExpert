package com.miguel.project.program.controllers;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.miguel.project.program.entities.dto.ProductDTO;
import com.miguel.project.program.services.ProductService;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(
    @RequestParam(name = "page", defaultValue = "0") Integer page,
    @RequestParam(name = "linesPerPage", defaultValue = "5") Integer linesPerPage,
    @RequestParam(name = "direction", defaultValue = "ASC") String direction,
    @RequestParam(name = "orderBy", defaultValue = "name") String orderBy
    ) {

        var pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        var products = productService.findAll(pageRequest);

        return ResponseEntity.ok(products.getContent());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {

        var product = productService.findById(id);

        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {

        var product = productService.save(productDTO);

        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {

        var product = productService.update(id, productDTO);

        return ResponseEntity.ok().body(new ProductDTO(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        
        productService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
