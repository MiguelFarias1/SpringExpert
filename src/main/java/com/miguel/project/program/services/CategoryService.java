package com.miguel.project.program.services;

import com.miguel.project.program.entities.Category;
import com.miguel.project.program.entities.dto.CategoryDTO;
import com.miguel.project.program.exceptions.EntityNotFoundException;
import com.miguel.project.program.repositories.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional(readOnly = true)
    public Page<CategoryDTO> findAllPaged(PageRequest request) {

        var list = categoryRepository.findAll(request);

        return list.map(CategoryDTO::new);
    }

    public CategoryDTO findById(Long id) {

        return categoryRepository
                .findById(id)
                .map(CategoryDTO::new)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
    }

    public Category save(CategoryDTO categoryDTO) {

        Category category = new Category(categoryDTO);

        return categoryRepository.save(category);
    }
}
