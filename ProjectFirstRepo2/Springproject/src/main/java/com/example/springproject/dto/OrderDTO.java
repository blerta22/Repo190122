package com.example.springproject.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderDTO {
    private Long id;
    private Long OrderNumber;
    private LocalDate OrderDate;
    private LocalDate ShipDate;
    private LocalDate RequiredDate;
    private double SalesTax;
    private String TransactStatus;
    private String ErrLoc;
    private boolean fullfielld;
    private boolean Deleted;
    private boolean Paid;
    private LocalDate PaymentDate;
    private Long customerId;
    private Long paymentId;
    private Long shipperId;




}
