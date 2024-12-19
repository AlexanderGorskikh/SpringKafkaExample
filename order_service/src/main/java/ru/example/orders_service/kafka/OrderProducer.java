package ru.example.orders_service.kafka;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.example.lib_dto.dto.OrderFullDto;

@Service
@AllArgsConstructor
public class OrderProducer {
    private static final String TOPIC = "new_orders";
    private KafkaTemplate<String, OrderFullDto> kafkaTemplate;
    private static final Logger logger = LoggerFactory.getLogger(OrderProducer.class);

    public void sendMessage(OrderFullDto orderFullDto) {
        logger.info("Sending order massage: {}", orderFullDto);
        kafkaTemplate.send(TOPIC, orderFullDto);
    }
}