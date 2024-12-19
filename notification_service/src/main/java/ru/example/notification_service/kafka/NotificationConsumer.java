package ru.example.notification_service.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.example.lib_dto.dto.OrderFullDto;
import ru.example.notification_service.service.NotificationService;

@Service
public class NotificationConsumer {
    private final NotificationService notificationService;

    private final static Logger logger = LoggerFactory.getLogger(NotificationConsumer.class);

    public NotificationConsumer(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @KafkaListener(topics = "sent_orders", groupId = "notification_group")
    public void consumeShippedOrder(OrderFullDto order) {
        logger.info("Received shipment order information: {}", order);
        notificationService.sendNotification(order);
    }
}
