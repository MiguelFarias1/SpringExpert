package com.miguel.project.program.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.miguel.project.program.entities.dto.CategoryDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity @Table(name = "tb_category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Instant createdAt;

    @ManyToMany(mappedBy = "categories", cascade = CascadeType.PERSIST)
    private Set<Product> products = new HashSet<>();

    public Category(CategoryDTO categoryDTO) {
        this.name = categoryDTO.getName();
        this.createdAt = categoryDTO.getCreatedAt();
    }
}
