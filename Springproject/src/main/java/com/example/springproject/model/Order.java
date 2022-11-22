package com.example.springproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="orders")
public class Order extends BaseEntity {

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

   @ManyToOne
   @JoinColumn(name="customer_id",referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="shipper_id",referencedColumnName = "id")
    private Shipper shipper;

    @ManyToOne
    @JoinColumn(name="payment_id",referencedColumnName = "id")
    private Payment payment;




}
