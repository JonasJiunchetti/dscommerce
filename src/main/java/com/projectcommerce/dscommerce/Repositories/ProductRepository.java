package com.projectcommerce.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectcommerce.dscommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
