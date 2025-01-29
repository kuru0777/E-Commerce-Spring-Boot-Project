package com.mehmetkuru.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class OrderItem extends BaseEntity {
    @ManyToOne
    private Product product;
    private Integer quantity;
    private Double purchasePrice;
} 