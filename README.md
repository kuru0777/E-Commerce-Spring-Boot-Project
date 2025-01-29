# E-Commerce Spring Boot Project

## Overview
This project is a simple e-commerce application built using Spring Boot. It includes basic functionalities for managing products, customers, carts, and orders. The application ensures that a customer can have a cart and multiple orders, and it maintains the integrity of product prices and stock levels.

## Features
- **Customer Management**: Add and manage customers.
- **Product Management**: Create, update, retrieve, and delete products.
- **Cart Management**: Add products to cart, update cart, empty cart, and calculate total price.
- **Order Management**: Place orders, retrieve orders by code, and get all orders for a customer.
- **Price History**: Maintain historical prices for products in orders.
- **Stock Management**: Ensure products cannot be ordered if out of stock.

## Services
### CustomerService
- `addCustomer(Customer customer)`: Adds a new customer.

### ProductService
- `createProduct(Product product)`: Creates a new product.
- `getProduct(Long id)`: Retrieves a product by ID.
- `updateProduct(Long id, Product product)`: Updates an existing product.
- `deleteProduct(Long id)`: Deletes a product by ID.

### CartService
- `getCart(Long customerId)`: Retrieves the cart for a customer.
- `updateCart(Long customerId, Cart cart)`: Updates the cart for a customer.
- `emptyCart(Long customerId)`: Empties the cart for a customer.
- `addProductToCart(Long customerId, Long productId, int quantity)`: Adds a product to the cart.
- `removeProductFromCart(Long customerId, Long productId)`: Removes a product from the cart.

### OrderService
- `placeOrder(Long customerId)`: Places an order for a customer.
- `getOrderByCode(String orderCode)`: Retrieves an order by its code.
- `getAllOrdersForCustomer(Long customerId)`: Retrieves all orders for a customer.

## Entities
- **BaseEntity**: Common fields for all entities (e.g., ID, timestamps).
- **Product**: Represents a product with fields like name, price, and stock quantity.
- **Customer**: Represents a customer with fields like name and contact information.
- **Cart**: Represents a shopping cart with a list of products and total price.
- **Order**: Represents an order with a list of products, total price, and historical prices.

## Example Code Snippet
```java
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
```

## Getting Started
1. Clone the repository:
   ```sh
   git clone https://github.com/kuru0777/E-Commerce-Spring-Boot-Project
   ```
2. Import the project into your IDE.
3. Configure the database connection in `application.properties`.
4. Run the application using:
   ```sh
   mvn spring-boot:run
   ```

## License
This project is licensed under the MIT License.

## Contributing
Feel free to submit issues and pull requests. For major changes, please open an issue first to discuss what you would like to change.

## Contact
For any inquiries, please contact [mehmetkuru0777@gmail.com](mailto:mehmetkuru0777@gmail.com).
