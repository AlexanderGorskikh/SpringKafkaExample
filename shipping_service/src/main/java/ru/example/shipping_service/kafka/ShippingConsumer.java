package ru.example.shipping_service.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.example.lib_dto.dto.OrderFullDto;
import ru.example.shipping_service.service.ShippingService;

@Service
public class ShippingConsumer {
    private final ShippingService shippedService;

    private final static Logger logger = LoggerFactory.getLogger(ShippingConsumer.class);

    public ShippingConsumer(ShippingService shippedService) {
        this.shippedService = shippedService;
    }

    @KafkaListener(topics = "new_orders", groupId = "payment_group")
    public void consume(OrderFullDto order) {
        logger.info("Received new order for payment {}", order);
        shippedService.processShipping(order);
    }
}
