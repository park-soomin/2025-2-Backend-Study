package com.example.shop.order;


import com.example.shop.order.dto.OrderrUpdateRequest;
import lombok.RequiredArgsConstructor;

import com.example.shop.order.dto.OrderCreateRequest;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class OrderService {

    private final OrderRepository orderRepository;

    //@Transactional
    public Long createOrder(OrderCreateRequest request) {
        Order existingOrder = orderRepository.findByOrderNumber(request.getOrderNumber());
        if (existingOrder != null) {
            throw new RuntimeException("이미 존재하는 주문번호입니다: " + request.getOrderNumber());
        }

        Order order = new Order(
                request.getOrderNumber(),
                request.getLoginId(),
                request.getPhoneNumber(),
                request.getAddress(),
                request.getTotalPrice()
        );

        orderRepository.save(order);

        return order.getId();
    }

    //@Transactional(readOnly = true)
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    //@Transactional(readOnly = true)
    public Order getOrderById(Long id) {
        Order order = orderRepository.findById(id);

        if (order == null) {
            throw new RuntimeException("주문을 찾을 수 없습니다.");
        }

        return order;
    }

    //@Transactional
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id);

        if (order == null) {
            throw new RuntimeException("주문을 찾을 수 없습니다.");
        }

        // Repository를 통해 삭제
        orderRepository.deleteById(id);
    }



}

