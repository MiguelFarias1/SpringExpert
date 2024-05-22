package com.miguel.project.program.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miguel.project.program.entities.Category;
import com.miguel.project.program.entities.dto.CategoryDTO;
import com.miguel.project.program.exceptions.EntityNotFoundException;
import com.miguel.project.program.repositories.CategoryRepository;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional(readOnly = true)
    public Page<Category> findAllPaged(PageRequest request) {

        return categoryRepository.findAll(request);
    }

    public Category findById(Long id) {

        return categoryRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
    }

    public Category save(CategoryDTO categoryDTO) {

        Category category = new Category(categoryDTO);

        return categoryRepository.save(category);
    }

    public void updateData(Category destiny, CategoryDTO source) {

        destiny.setName(source.getName());
        destiny.setCreatedAt(source.getCreatedAt());
    }

    public Category update(Long id, CategoryDTO updated) {
        
        var category = categoryRepository.getReferenceById(id);

        if(category == null) 
            throw new EntityNotFoundException("category with id " + id + " not found");
        
        updateData(category, updated);

        return categoryRepository.save(category);
    }

    public void delete(Long id) {

        categoryRepository.deleteById(id);
    }
}
