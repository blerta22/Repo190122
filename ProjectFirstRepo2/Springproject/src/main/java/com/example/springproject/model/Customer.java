package com.example.springproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customers")
public class Customer extends BaseEntity{

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
    private String Password;
    private String CreditCard;
    private String BillingAddress;
    private String ShippingAddres;
    private LocalDate DateEntered;

    @OneToMany(mappedBy ="customer",cascade = CascadeType.ALL)
    private Set<Order> orders=new HashSet<>();

}
