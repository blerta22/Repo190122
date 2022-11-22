package com.example.springproject.model;

import javax.persistence.*;
import java.util.Date;


@Entity
public class OrderDetails {
    @EmbeddedId
    private CKOrderDetail ckOrderDetail;


    public CKOrderDetail getCkOrderDetail() {
        return ckOrderDetail;
    }

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name="order_id")
    private Order order;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name="product_id")
    private Product product;

    private double price;
    private int quantity;
    private double discount;
    private double total;
    private double size;
    private String color;
    private boolean fullfilled;
    @Temporal(TemporalType.DATE)
    private Date shipDate;
    @Temporal(TemporalType.DATE)
    private Date billDate;

    public OrderDetails(CKOrderDetail ckOrderDetail, double price, int quantity, double discount, double total, double size, String color, boolean fullfilled, Date shipDate, Date billDate) {
        this.ckOrderDetail = new CKOrderDetail(order.getId(), product.getId());
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
        this.total = total;
        this.size = size;
        this.color = color;
        this.fullfilled = fullfilled;
        this.shipDate = shipDate;
        this.billDate = billDate;
    }

    public OrderDetails() {
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFullfilled() {
        return fullfilled;
    }

    public void setFullfilled(boolean fullfilled) {
        this.fullfilled = fullfilled;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public void setCkOrderDetail(CKOrderDetail ckOrderDetail) {
        this.ckOrderDetail = ckOrderDetail;
    }


}


