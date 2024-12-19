package ru.example.orders_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.orders_service.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}