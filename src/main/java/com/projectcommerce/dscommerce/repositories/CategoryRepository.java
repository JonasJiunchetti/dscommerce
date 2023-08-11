package com.projectcommerce.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projectcommerce.dscommerce.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
    
}
