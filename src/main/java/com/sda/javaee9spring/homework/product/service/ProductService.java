package com.sda.javaee9spring.homework.product.service;

import com.sda.javaee9spring.homework.product.entity.Product;
import com.sda.javaee9spring.homework.product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> readAllProducts() {
        log.info("Trying to read all products");

        var products = productRepository.findAll();
        for (Product product : products) {
            addVatTax(product);
        }
        log.info("Person entities read from are: " + products);
        return products;
    }

    public Product findProductById(Long productId) {
        log.info("Trying to find product by id " + productId);
        Product product = null;

        var maybeProduct = productRepository.findById(productId);
        if (maybeProduct.isPresent()) {
            product = maybeProduct.get();
            addVatTax(product);
        }
        log.info("Found Product: [{}]", product);
        return product;
    }

    public void addVatTax(Product product) {
        product.setPrice(product.getPrice() * 1.23);
    }
}
