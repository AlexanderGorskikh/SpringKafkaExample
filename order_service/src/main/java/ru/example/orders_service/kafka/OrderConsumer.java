package ru.example.orders_service.kafka;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.example.lib_dto.dto.OrderFullDto;
import ru.example.orders_service.service.OrderService;

@Service
@AllArgsConstructor
public class OrderConsumer {
    private final OrderService orderService;

    private static final Logger logger = LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(topics = "payed_orders", groupId = "orders_group")
    public void consumePayedOrder(OrderFullDto order) {
        logger.info("Received payed order message: {}", order);
        orderService.updateOrderStatus(order.getId(),order.getStatus());
    }

    @KafkaListener(topics = "shipped_orders", groupId = "orders_group")
    public void consumeShippedOrder(OrderFullDto order) {
        logger.info("Received shipping order message: {}", order);
        orderService.updateOrderStatus(order.getId(),order.getStatus());
    }

    @KafkaListener(topics = "notified_orders", groupId = "orders_group")
    public void consumeNotifiedOrder(OrderFullDto order) {
        logger.info("Received notify: {}", order);
        orderService.updateOrderStatus(order.getId(),order.getStatus());
    }
}
