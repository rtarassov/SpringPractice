package com.sda.javaee9spring.homework.product.repository;

import com.sda.javaee9spring.homework.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
