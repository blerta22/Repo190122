package com.example.springproject.converters;

import com.example.springproject.dto.OrderDTO;
import com.example.springproject.model.Order;
import org.springframework.core.convert.converter.Converter;

public class OrdertoOrderDTO implements Converter<Order, OrderDTO> {


    @Override
    public OrderDTO convert(Order source) {
        if(source!=null){
            OrderDTO orderDTO=new OrderDTO();
            orderDTO.setOrderNumber(source.getOrderNumber());
            orderDTO.setOrderDate(source.getOrderDate());
            orderDTO.setPaid(source.isPaid());
            orderDTO.setDeleted(source.isDeleted());
            orderDTO.setPaymentDate(source.getPaymentDate());
            orderDTO.setRequiredDate(source.getRequiredDate());
            orderDTO.setFullfielld(source.isFullfielld());
            orderDTO.setSalesTax(source.getSalesTax());
            orderDTO.setShipDate(source.getShipDate());
            orderDTO.setErrLoc(source.getErrLoc());
            orderDTO.setTransactStatus(source.getTransactStatus());
            orderDTO.setCustomerId(source.getCustomer().getId());
            orderDTO.setPaymentId(source.getPayment().getId());
            orderDTO.setShipperId(source.getShipper().getId());
            return orderDTO;
        }
        return null;
    }
}
