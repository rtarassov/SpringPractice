package com.sda.javaee9spring.homework.product.controller;

import com.sda.javaee9spring.homework.product.entity.Product;
import com.sda.javaee9spring.homework.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/products")
public class ProductRestController {

    private final ProductService productService;

    @Autowired
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all-products")
    public List<Product> findAllProducts() {
        log.info("readAllProducts() called from productService");
        return productService.readAllProducts();
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable("id") Long productId) {
        log.info("Trying to find a product by id [{}]", productId);
        return productService.findProductById(productId);
    }


}
