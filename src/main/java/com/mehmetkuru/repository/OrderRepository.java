package com.mehmetkuru.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mehmetkuru.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomerId(Long customerId);
    Order findByOrderCode(String orderCode);
} 