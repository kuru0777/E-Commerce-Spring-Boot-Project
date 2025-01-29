package com.mehmetkuru.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.mehmetkuru.model.Cart;
import com.mehmetkuru.model.CartItem;
import com.mehmetkuru.model.Customer;
import com.mehmetkuru.model.Order;
import com.mehmetkuru.model.OrderItem;
import com.mehmetkuru.model.Product;
import com.mehmetkuru.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductService productService;
    
    public Order placeOrder(Customer customer, Cart cart) {
        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderCode(UUID.randomUUID().toString());
        
        for (CartItem cartItem : cart.getItems()) {
            Product product = cartItem.getProduct();
            if (product.getStockQuantity() < cartItem.getQuantity()) {
                throw new RuntimeException("Not enough stock for " + product.getName());
            }
            
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPurchasePrice(cartItem.getPrice());
            
            order.getItems().add(orderItem);
            
            
            product.setStockQuantity(product.getStockQuantity() - cartItem.getQuantity());
            productService.updateProduct(product.getId(), product);
        }
        
        order.setTotalPrice(cart.getTotalPrice());
        return orderRepository.save(order);
    }
    
    public Order getOrderByCode(String orderCode) {
        return orderRepository.findByOrderCode(orderCode);
    }
    
    public List<Order> getAllOrdersForCustomer(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }
} 