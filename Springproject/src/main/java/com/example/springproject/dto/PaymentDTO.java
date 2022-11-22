package com.example.springproject.dto;

import lombok.Data;

@Data
public class PaymentDTO {
    private Long id;
    private String PaymentType;
    private boolean Allowed;

}
