package com.projectcommerce.dscommerce.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projectcommerce.dscommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
    @Query("SELECT obj FROM Product obj " +
        "WHERE UPPER(obj.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<Product> searchByName(String name, Pageable pageable); // by using "pageable" on the method's argument, It returns a pageable result 

    /* @Query("SELECT obj FROM Product obj JOIN FETCH obj.categories " +
        "WHERE obj.id =:id")
    Product searchById(Long id); */
}
