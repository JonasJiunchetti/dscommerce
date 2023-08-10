package com.projectcommerce.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectcommerce.dscommerce.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
