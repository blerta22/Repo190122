package com.example.springproject.converters;

import com.example.springproject.dto.OrderDetailsDTO;
import com.example.springproject.exceptions.NotFoundException;
import com.example.springproject.model.OrderDetails;
import org.springframework.core.convert.converter.Converter;

public class OrderDetailsToOrderDetailsDTO implements Converter<OrderDetails, OrderDetailsDTO> {





    @Override
    public OrderDetailsDTO convert(OrderDetails source) {
        if(source!=null){
            OrderDetailsDTO orderDetailsDTO=new OrderDetailsDTO();
            if(source.getOrder()!=null&&source.getProduct()!=null) {
                orderDetailsDTO.setOrderId(source.getOrder().getId());
                orderDetailsDTO.setProductId(source.getProduct().getId());

            }

            orderDetailsDTO.setDiscount(source.getDiscount());
            orderDetailsDTO.setColor(source.getColor());
            orderDetailsDTO.setFullfilled(source.isFullfilled());
            orderDetailsDTO.setPrice(source.getPrice());
            orderDetailsDTO.setQuantity(source.getQuantity());
            orderDetailsDTO.setBillDate(source.getBillDate());
            orderDetailsDTO.setShipDate(source.getShipDate());
            orderDetailsDTO.setSize(source.getSize());
            orderDetailsDTO.setTotal(source.getTotal());
            return orderDetailsDTO;

        }
        return null;
    }
}
