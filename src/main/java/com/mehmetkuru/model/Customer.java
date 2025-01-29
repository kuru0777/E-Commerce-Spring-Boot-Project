package com.mehmetkuru.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Customer extends BaseEntity {
    private String name;
    private String email;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;
} 