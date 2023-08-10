package com.projectcommerce.dscommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projectcommerce.dscommerce.dto.OrderDTO;
import com.projectcommerce.dscommerce.services.exceptions.ResourceNotFoundException;
import com.projectcommerce.dscommerce.entities.Order;
import com.projectcommerce.dscommerce.repositories.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;
    
    @Transactional(readOnly = true)
    public OrderDTO findById(Long id){
        Order order = repository.findById(id).orElseThrow(
          () -> new ResourceNotFoundException("Resource not found"));
        return new OrderDTO(order);
    }
}
