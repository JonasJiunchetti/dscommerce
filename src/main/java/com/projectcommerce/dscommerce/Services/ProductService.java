package com.projectcommerce.dscommerce.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectcommerce.dscommerce.DTO.ProductDTO;
import com.projectcommerce.dscommerce.Entities.Product;
import com.projectcommerce.dscommerce.Repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;
    
    public ProductDTO findById(Long id){
        Product product = repository.findById(id).get();
        return new ProductDTO(product);

    }
}
