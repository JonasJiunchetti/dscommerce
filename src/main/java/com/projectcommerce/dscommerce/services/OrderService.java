package com.projectcommerce.dscommerce.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projectcommerce.dscommerce.dto.OrderDTO;
import com.projectcommerce.dscommerce.dto.OrderItemDTO;
import com.projectcommerce.dscommerce.services.exceptions.ResourceNotFoundException;

import jakarta.validation.Valid;

import com.projectcommerce.dscommerce.entities.Order;
import com.projectcommerce.dscommerce.entities.OrderItem;
import com.projectcommerce.dscommerce.entities.OrderStatus;
import com.projectcommerce.dscommerce.entities.Product;
import com.projectcommerce.dscommerce.entities.User;
import com.projectcommerce.dscommerce.repositories.OrderItemRepository;
import com.projectcommerce.dscommerce.repositories.OrderRepository;
import com.projectcommerce.dscommerce.repositories.ProductRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;
    
    @Transactional(readOnly = true)
    public OrderDTO findById(Long id){
        Order order = repository.findById(id).orElseThrow(
          () -> new ResourceNotFoundException("Resource not found"));
          authService.validadeSelfOrAdmin(order.getClient().getId());
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO insert(OrderDTO dto) {
        Order order = new Order();

        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);

        User user = userService.authenticated();
        order.setClient(user);
        
        for(OrderItemDTO orderDto : dto.getItems()){
          Product product = productRepository.getReferenceById(orderDto.getProductId());
          OrderItem item = new OrderItem(order, product, orderDto.getQuantity(), product.getPrice());
          order.getItems().add(item); 
        }

        repository.save(order);
        orderItemRepository.saveAll(order.getItems());

        return new OrderDTO(order);
    }
}
