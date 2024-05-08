package com.miguel.project.program.entities.dto;

import com.miguel.project.program.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class CategoryDTO implements Serializable {

    private String name;

    public CategoryDTO(Category category) {
        this.name = category.getName();
    }
}
