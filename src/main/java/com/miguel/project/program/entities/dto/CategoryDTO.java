package com.miguel.project.program.entities.dto;

import com.miguel.project.program.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class CategoryDTO implements Serializable {

    private String name;
    private Instant createdAt;

    public CategoryDTO(Category category) {
        this.name = category.getName();
        this.createdAt = category.getCreatedAt();
    }
}
