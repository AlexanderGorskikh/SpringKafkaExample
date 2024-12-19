package ru.example.payment_service.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.example.lib_dto.dto.OrderFullDto;
import ru.example.payment_service.service.PaymentService;

@Service
public class PaymentProducer {
    private static final String TOPIC = "payed_orders";


    private final KafkaTemplate<String, OrderFullDto> kafkaTemplate;

    private static final Logger logger = LoggerFactory.getLogger(PaymentProducer.class);

    public PaymentProducer(KafkaTemplate<String, OrderFullDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(OrderFullDto order) {
        logger.info("sending to shipment order information {}", order);
        kafkaTemplate.send(TOPIC, order);
    }
}
