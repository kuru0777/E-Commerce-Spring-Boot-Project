package com.mehmetkuru.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseEntity {
    private String name;
    private Double price;
    private Integer stockQuantity;
} 