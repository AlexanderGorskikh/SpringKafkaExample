package ru.example.shipping_service.service;

import org.springframework.stereotype.Service;
import ru.example.lib_dto.dto.OrderFullDto;
import ru.example.shipping_service.kafka.ShippingProducer;

@Service
public class ShippingService {
    private final ShippingProducer shippingProducer;

    public ShippingService(ShippingProducer shippingProducer) {
        this.shippingProducer = shippingProducer;
    }

    public void processShipping(OrderFullDto order) {
        // Логика отгрузки
        order.setStatus("SHIPPED");
        shippingProducer.sendMessage(order);
    }
}
