package com.demo.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.dto.OrderDTO;
import com.demo.exceptions.*;
import com.demo.entities.Orders;
import com.demo.repositories.OrderRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
       


    }

    @Override
    public ResponseEntity<OrderDTO> createOrder(Long userId, OrderDTO orderDTO) {
        Orders order = modelMapper.map(orderDTO, Orders.class);
       // order.setOrderId(userId);
        orderRepository.save(order);

        OrderDTO createdOrderDTO = modelMapper.map(order, OrderDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderDTO);
    }

    @Override
    public ResponseEntity<OrderDTO> getOrderById(Long orderId) {
        Orders order = getOrderEntityById(orderId);
        OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);
        return ResponseEntity.status(HttpStatus.OK).body(orderDTO);
    }

    @Override
    public ResponseEntity<List<OrderDTO>> getOrdersByUserId(Long userId) {
        Optional<Orders> orders = orderRepository.findById(userId);
        List<OrderDTO> orderDTOs = orders.stream().map(order -> modelMapper.map(order, OrderDTO.class)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(orderDTOs);
    }

    @Override
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<Orders> orders = orderRepository.findAll();
        List<OrderDTO> orderDTOs = orders.stream().map(order -> modelMapper.map(order, OrderDTO.class)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(orderDTOs);
    }

    @Override
    public ResponseEntity<Void> updateOrder(Long orderId, OrderDTO orderDTO) {
        Orders existingOrder = getOrderEntityById(orderId);

        // Update fields based on your requirement
        modelMapper.map(orderDTO, existingOrder);

        orderRepository.save(existingOrder);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<Void> deleteOrder(Long orderId) {
        Orders order = getOrderEntityById(orderId);
        orderRepository.delete(order);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    private Orders getOrderEntityById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + orderId));
    }
}
