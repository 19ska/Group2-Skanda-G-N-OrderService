package com.demo.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.demo.dto.OrderDTO;
import com.demo.entities.OrderStatus;

public interface OrderService {
	
	ResponseEntity<OrderDTO> createOrder(OrderDTO orderDTO);

    ResponseEntity<OrderDTO> getOrderById(Long orderId);
    
//  ResponseEntity<List<OrderDTO>> getOrdersByCustomerId(Long customerId);

  ResponseEntity<List<OrderDTO>> getAllOrders();
  //comment

  ResponseEntity<Void> updateOrderStatus(Long orderId, OrderStatus newStatus);

  ResponseEntity<Void> deleteOrder(Long orderId);

}
