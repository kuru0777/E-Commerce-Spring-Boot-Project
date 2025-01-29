package com.mehmetkuru.repository;

import com.mehmetkuru.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
} 