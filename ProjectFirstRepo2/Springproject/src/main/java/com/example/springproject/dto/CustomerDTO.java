package com.example.springproject.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerDTO {
    private Long id;
    private String FirstName;
    private String LastName;
    private String Adress1;
    private String Adress2;
    private String City;
    private String State;
    private Long PostalCode;
    private String Country;
    private String Phone;
    private String Email;
    private String CreditCard;
    private String BillingAddress;
    private String ShippingAddres;
    private LocalDate DateEntered;

}
