package ru.example.lib_dto.dto;

import java.math.BigDecimal;

public class OrderFullDto {
    private Long id;
    private BigDecimal price;
    private String description;
    private String status;

    public OrderFullDto() {
    }

    public OrderFullDto(Long id, BigDecimal price, String description, String status) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
