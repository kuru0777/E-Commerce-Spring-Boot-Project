package com.mehmetkuru.service;

import org.springframework.stereotype.Service;

import com.mehmetkuru.model.Cart;
import com.mehmetkuru.model.CartItem;
import com.mehmetkuru.model.Product;
import com.mehmetkuru.repository.CartRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final ProductService productService;
    
    public Cart addProductToCart(Cart cart, Long productId, Integer quantity) {
        Product product = productService.getProduct(productId);
        
        if (product.getStockQuantity() < quantity) {
            throw new RuntimeException("Not enough stock");
        }
        
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        cartItem.setPrice(product.getPrice());
        
        cart.getItems().add(cartItem);
        cart.setTotalPrice(calculateTotalPrice(cart));
        
        return cartRepository.save(cart);
    }
    
    private Double calculateTotalPrice(Cart cart) {
        return cart.getItems().stream()
            .mapToDouble(item -> item.getPrice() * item.getQuantity())
            .sum();
    }

    public Cart getCart(Long id) {
        return cartRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cart not found"));
    }

    public Cart updateCart(Cart cart) {
        return cartRepository.save(cart);
    }
    
    public Cart emptyCart(Long cartId) {
        Cart cart = getCart(cartId);
        cart.getItems().clear();
        cart.setTotalPrice(0.0);
        return cartRepository.save(cart);
    }
    
    public Cart removeProductFromCart(Cart cart, Long productId) {
        cart.getItems().removeIf(item -> item.getProduct().getId().equals(productId));
        cart.setTotalPrice(calculateTotalPrice(cart));
        return cartRepository.save(cart);
    }
} 