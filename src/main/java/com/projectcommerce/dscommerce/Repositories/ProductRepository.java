package com.projectcommerce.dscommerce.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectcommerce.dscommerce.Entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
