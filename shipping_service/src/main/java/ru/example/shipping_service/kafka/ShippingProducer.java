package ru.example.shipping_service.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.example.lib_dto.dto.OrderFullDto;

@Service
public class ShippingProducer {
    private static final String TOPIC = "sent_orders";

    private final KafkaTemplate<String, OrderFullDto> kafkaTemplate;

    private static final Logger logger = LoggerFactory.getLogger(ShippingProducer.class);

    public ShippingProducer(KafkaTemplate<String, OrderFullDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(OrderFullDto order) {
        logger.info("sending to shipment order information {}", order);
        kafkaTemplate.send(TOPIC, order);
    }
}
