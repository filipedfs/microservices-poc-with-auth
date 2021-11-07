package com.filipefonseca.orderservice.repository;

import com.filipefonseca.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
