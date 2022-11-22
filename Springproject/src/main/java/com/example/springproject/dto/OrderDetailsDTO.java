package com.example.springproject.dto;

import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class OrderDetailsDTO {
    private double price;
    private int quantity;
    private double discount;
    private double total;
    private double size;
    private String color;
    private boolean fullfilled;
    private Date shipDate;
    private Date billDate;
    private Long orderId;
    private Long productId;
}
