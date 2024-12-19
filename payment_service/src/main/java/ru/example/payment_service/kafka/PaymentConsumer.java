package ru.example.payment_service.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.example.lib_dto.dto.OrderFullDto;
import ru.example.payment_service.service.PaymentService;

@Service
public class PaymentConsumer {
    private final PaymentService paymentService;

    private final static Logger logger = LoggerFactory.getLogger(PaymentConsumer.class);

    public PaymentConsumer(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @KafkaListener(topics = "new_orders", groupId = "payment_group")
    public void consume(OrderFullDto order) {
        logger.info("Received new order for payment {}", order);
        paymentService.processPayment(order);
    }
}
