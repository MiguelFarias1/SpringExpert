package com.miguel.project.program.entities.dto;

import com.miguel.project.program.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Getter @Setter
@AllArgsConstructor
public class ProductDTO implements Serializable {

    private String name;

    private String description;

    private BigDecimal price;

    private String imgUrl;

    private Instant date;

    public ProductDTO(Product product) {
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.imgUrl = product.getImgUrl();
        this.date = product.getDate();
    }
}
