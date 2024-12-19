package ru.example.orders_service.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.example.lib_dto.dto.OrderFullDto;
import ru.example.orders_service.dto.OrderDto;
import ru.example.orders_service.kafka.OrderProducer;
import ru.example.orders_service.model.Order;
import ru.example.orders_service.repository.OrderRepository;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private OrderProducer orderProducer;

    public OrderService(OrderRepository orderRepository, OrderProducer orderProducer) {
        this.orderRepository = orderRepository;
        this.orderProducer = orderProducer;
    }

    @Transactional
    public Order createOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setDescription(orderDto.getDescription());
        order.setPrice(orderDto.getPrice());
        order.setStatus("NEW");
        Order saved = orderRepository.save(order);
        orderProducer.sendMessage(new OrderFullDto(saved.getId(), saved.getPrice(), saved.getDescription(), saved.getStatus()));
        return saved;
    }

    public void updateOrderStatus(Long id, String status) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        orderRepository.save(order);
    }
}
