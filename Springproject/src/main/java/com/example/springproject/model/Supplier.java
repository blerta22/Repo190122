package com.example.springproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Supplier extends BaseEntity{
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
    private String TypeGoods;
    private String Notes;
    private String CurrentOrder;
    private String Logo;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    private Set<Products> products = new HashSet<>();






}
