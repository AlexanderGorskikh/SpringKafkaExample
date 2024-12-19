package ru.example.notification_service.service;

import org.springframework.stereotype.Service;
import ru.example.lib_dto.dto.OrderFullDto;
import ru.example.notification_service.kafka.NotificationProducer;

@Service
public class NotificationService {
    private final NotificationProducer notificationProducer;

    public NotificationService(NotificationProducer notificationProducer) {
        this.notificationProducer = notificationProducer;
    }

    public void sendNotification(OrderFullDto order) {
        order.setStatus("COMPLETED");
        notificationProducer.sendMessage(order);
    }
}
