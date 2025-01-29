package com.mehmetkuru.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mehmetkuru.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
} 