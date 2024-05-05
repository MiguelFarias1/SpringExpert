package com.miguel.project.program.services;

import com.miguel.project.program.entities.Category;
import com.miguel.project.program.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {

        return categoryRepository.findAll();
    }
}
