package com.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.dto.Order;
import com.order.repository.OrderRepository;

@Service
public class OrderService {
  @Autowired
  private OrderRepository orderRepository;

  public Order save(Order entity) {
    return orderRepository.save(entity);
  }
}
