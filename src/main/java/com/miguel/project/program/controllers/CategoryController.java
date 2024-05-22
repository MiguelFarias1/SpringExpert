package com.miguel.project.program.controllers;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.miguel.project.program.entities.Category;
import com.miguel.project.program.entities.dto.CategoryDTO;
import com.miguel.project.program.services.CategoryService;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(final CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<CategoryDTO>> findAll(
    @RequestParam(value = "page",defaultValue = "0") Integer page,
    @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
    @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
    @RequestParam(value = "direction", defaultValue = "ASC") String direction
    ) {

        PageRequest request = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        var list = categoryService.findAllPaged(request);

        var listDTO = list
                    .getContent()
                    .stream()
                    .map(CategoryDTO::new)
                    .toList();

        return ResponseEntity
            .ok()
            .body(listDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Category> getCategoryById(final @PathVariable Long id) {

        var category = categoryService.findById(id);

        return ResponseEntity.ok().body(category);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
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
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<CategoryDTO> updateCategory(final @PathVariable Long id, final @RequestBody CategoryDTO categoryDTO) {
        
        var category = categoryService.update(id, categoryDTO);

        var dto = new CategoryDTO(category);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteCategory(final @PathVariable Long id) {
        
        categoryService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
