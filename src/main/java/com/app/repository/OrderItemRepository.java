package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.modal.*;
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
