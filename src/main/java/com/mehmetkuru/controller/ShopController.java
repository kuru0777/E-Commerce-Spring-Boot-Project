package com.mehmetkuru.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mehmetkuru.model.Cart;
import com.mehmetkuru.model.Customer;
import com.mehmetkuru.model.Order;
import com.mehmetkuru.model.Product;
import com.mehmetkuru.service.CartService;
import com.mehmetkuru.service.CustomerService;
import com.mehmetkuru.service.OrderService;
import com.mehmetkuru.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ShopController {
    private final ProductService productService;
    private final CartService cartService;
    private final OrderService orderService;
    private final CustomerService customerService;
    
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
    
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }
    
    @PostMapping("/cart/{cartId}/products/{productId}")
    public Cart addToCart(@PathVariable Long cartId, @PathVariable Long productId, 
                         @RequestParam Integer quantity) {
        Cart cart = cartService.getCart(cartId);
        return cartService.addProductToCart(cart, productId, quantity);
    }
    
    @PostMapping("/orders")
    public Order placeOrder(@RequestParam Long customerId) {
        Customer customer = customerService.getCustomer(customerId);
        Cart cart = customer.getCart();
        return orderService.placeOrder(customer, cart);
    }
    
    @GetMapping("/orders/{orderCode}")
    public Order getOrder(@PathVariable String orderCode) {
        return orderService.getOrderByCode(orderCode);
    }
    
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }
    
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }
    
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
    
    @PutMapping("/cart/{cartId}")
    public Cart updateCart(@PathVariable Long cartId, @RequestBody Cart cart) {
        return cartService.updateCart(cart);
    }
    
    @DeleteMapping("/cart/{cartId}")
    public Cart emptyCart(@PathVariable Long cartId) {
        return cartService.emptyCart(cartId);
    }
    
    @DeleteMapping("/cart/{cartId}/products/{productId}")
    public Cart removeProductFromCart(@PathVariable Long cartId, @PathVariable Long productId) {
        Cart cart = cartService.getCart(cartId);
        return cartService.removeProductFromCart(cart, productId);
    }
    
    @GetMapping("/customers/{customerId}/orders")
    public List<Order> getAllOrdersForCustomer(@PathVariable Long customerId) {
        return orderService.getAllOrdersForCustomer(customerId);
    }
    
    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
} 