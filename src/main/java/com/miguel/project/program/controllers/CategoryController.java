package com.miguel.project.program.controllers;

import com.miguel.project.program.entities.Category;
import com.miguel.project.program.entities.dto.CategoryDTO;
import com.miguel.project.program.services.CategoryService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(final CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll(
    @RequestParam(value = "page",defaultValue = "0") Integer page,
    @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
    @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
    @RequestParam(value = "direction", defaultValue = "ASC") String direction
    ) {

        PageRequest request = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        var list = categoryService.findAllPaged(request);

        return ResponseEntity.ok().body(list.getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(final @PathVariable Long id) {

        return null;
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(final @RequestBody CategoryDTO categoryDTO) {

        var category = categoryService.save(categoryDTO);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(category.getId())
                .toUri();

        return ResponseEntity
                .created(uri)
                .build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(final @PathVariable Long id, final @RequestBody CategoryDTO categoryDTO) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(final @PathVariable Long id) {
        return null;
    }
}
