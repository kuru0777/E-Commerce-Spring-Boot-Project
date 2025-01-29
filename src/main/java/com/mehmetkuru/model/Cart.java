package com.mehmetkuru.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Cart extends BaseEntity {
    @OneToMany(cascade = CascadeType.ALL)
    private List<CartItem> items = new ArrayList<>();
    
    private Double totalPrice = 0.0;
} 