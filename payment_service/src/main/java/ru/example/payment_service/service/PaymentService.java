package ru.example.payment_service.service;

import org.springframework.stereotype.Service;
import ru.example.lib_dto.dto.OrderFullDto;

@Service
public class PaymentService {
    public void processPayment(OrderFullDto order) {
        order.setStatus("PAYED");
        processPayment(order);
    }
}
