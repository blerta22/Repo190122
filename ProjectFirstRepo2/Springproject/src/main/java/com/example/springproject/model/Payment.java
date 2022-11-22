package com.example.springproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="payments")
public class Payment extends BaseEntity {

    private String PaymentType;
    private boolean Allowed;
    @OneToMany(mappedBy = "payment",cascade = CascadeType.ALL)
    private Set<Order> orders=new HashSet<>();






}
