package com.example.springproject.dto;

import lombok.Data;

@Data
public class SuppliersDTO {
    private Long id;
    private String CompanyName;
    private String ContactFName;
    private String ContactLName;
    private String Address1;
    private String Address2;
    private String City;
    private String State;
    private Integer PostalCode;
    private String Country;
    private Integer Phone;
    private String Email;
    private String URL;
    private String PaymentMethods;
    private String CurrentOrder;

}
