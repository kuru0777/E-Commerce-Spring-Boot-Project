package com.mehmetkuru.service;

import org.springframework.stereotype.Service;

import com.mehmetkuru.model.Product;
import com.mehmetkuru.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    
    public Product getProduct(Long id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found"));
    }
    
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = getProduct(id);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStockQuantity(product.getStockQuantity());
        return productRepository.save(existingProduct);
    }
    
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
} 