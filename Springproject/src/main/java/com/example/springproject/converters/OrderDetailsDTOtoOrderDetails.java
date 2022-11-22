package com.example.springproject.converters;

import com.example.springproject.dto.OrderDetailsDTO;
import com.example.springproject.exceptions.NotFoundException;
import com.example.springproject.model.OrderDetails;
import com.example.springproject.repositories.OrderRepository;
import com.example.springproject.repositories.ProductsRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.crossstore.ChangeSetPersister;


public class OrderDetailsDTOtoOrderDetails implements Converter<OrderDetailsDTO, OrderDetails> {
private final OrderRepository orderRepository;
private final ProductsRepository productsRepository;

    public OrderDetailsDTOtoOrderDetails(OrderRepository orderRepository, ProductsRepository productsRepository) {
        this.orderRepository = orderRepository;
        this.productsRepository = productsRepository;
    }

    @Override
    public OrderDetails convert(OrderDetailsDTO source) {

        if(source!=null){

         OrderDetails orderDetails=new OrderDetails();
         if(source.getOrderId()!=null&&source.getProductId()!=null){

        orderDetails.setOrder(source.getOrderId()==null?null:orderRepository.findById(source.getOrderId()).orElseThrow(()->new NotFoundException("Order with id"+source.getOrderId()+"does not exist")));
        orderDetails.setProduct(source.getProductId()==null?null:productsRepository.findById(source.getProductId()).orElseThrow(()->new NotFoundException("Product with id"+source.getProductId()+"does not exist")));
        orderDetails.setDiscount(source.getDiscount());
        orderDetails.setColor(source.getColor());
        orderDetails.setFullfilled(source.isFullfilled());
        orderDetails.setPrice(source.getPrice());
        orderDetails.setQuantity(source.getQuantity());
        orderDetails.setBillDate(source.getBillDate());
        orderDetails.setShipDate(source.getShipDate());
        orderDetails.setSize(source.getSize());
        orderDetails.setTotal(source.getTotal());



         }

        }

        return null;
    }
}
