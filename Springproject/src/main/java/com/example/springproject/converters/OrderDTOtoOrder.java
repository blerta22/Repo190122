package com.example.springproject.converters;

import com.example.springproject.dto.OrderDTO;
import com.example.springproject.model.Order;
import com.example.springproject.repositories.CustomerRepository;
import com.example.springproject.repositories.PaymentRepository;
import com.example.springproject.repositories.ShipperRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OrderDTOtoOrder implements Converter<OrderDTO, Order> {

private final CustomerRepository customerRepository;
private final ShipperRepository shipperRepository;
private final PaymentRepository paymentRepository;

    public OrderDTOtoOrder(CustomerRepository customerRepository, ShipperRepository shipperRepository, PaymentRepository paymentRepository) {
        this.customerRepository = customerRepository;
        this.shipperRepository = shipperRepository;
        this.paymentRepository = paymentRepository;
    }


    @Override
    public Order convert(OrderDTO source) {
        if(source.getId()!=null){
            Order order=new Order();
            if(source.getId()!=null){
                order.setId(order.getId());}
              order.setOrderNumber(source.getOrderNumber());
              order.setOrderDate(source.getOrderDate());
              order.setPaid(source.isPaid());
              order.setDeleted(source.isDeleted());
              order.setPaymentDate(source.getPaymentDate());
              order.setRequiredDate(source.getRequiredDate());
              order.setFullfielld(source.isFullfielld());
              order.setSalesTax(source.getSalesTax());
              order.setShipDate(source.getShipDate());
              order.setErrLoc(source.getErrLoc());
              order.setTransactStatus(source.getTransactStatus());
              order.setPayment(paymentRepository.findById(source.getPaymentId()).get());
              order.setCustomer(customerRepository.findById(source.getCustomerId()).get());
              order.setShipper(shipperRepository.findById(source.getShipperId()).get());
              return order;
            }
        return null;
    }
}
