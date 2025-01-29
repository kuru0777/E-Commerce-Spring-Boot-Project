package com.mehmetkuru.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mehmetkuru.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
} 