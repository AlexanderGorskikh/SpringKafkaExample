package ru.example.notification_service.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.example.lib_dto.dto.OrderFullDto;

@Service
public class NotificationProducer {
    private static final String TOPIC = "notified_orders";

    private final KafkaTemplate<String, OrderFullDto> kafkaTemplate;

    private final static Logger logger = LoggerFactory.getLogger(NotificationProducer.class);

    public NotificationProducer(KafkaTemplate<String, OrderFullDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(OrderFullDto orderDTO) {
        logger.info("Sending notification to user: {}", orderDTO);
        kafkaTemplate.send(TOPIC, orderDTO);
    }
}
