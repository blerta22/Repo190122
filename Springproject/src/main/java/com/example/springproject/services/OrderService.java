package com.example.springproject.services;

import com.example.springproject.converters.OrderDTOtoOrder;
import com.example.springproject.converters.OrdertoOrderDTO;
import com.example.springproject.dto.OrderDTO;
import com.example.springproject.exceptions.NotFoundException;
import com.example.springproject.repositories.OrderRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

private final OrderRepository orderRepository;

private final OrderDTOtoOrder orderDTOtoOrder;
private final OrdertoOrderDTO ordertoOrderDTO;



    public OrderService(OrderRepository orderRepository, OrderDTOtoOrder orderDTOtoOrder, OrdertoOrderDTO ordertoOrderDTO) {
        this.orderRepository = orderRepository;
        this.orderDTOtoOrder = orderDTOtoOrder;
        this.ordertoOrderDTO = ordertoOrderDTO;
    }

    public List<OrderDTO> findAll() {
        return orderRepository.findAll().stream().map(order ->ordertoOrderDTO.convert(order)).collect(Collectors.toList());
    }

    public OrderDTO findOrderById(String id) {
        Long parseId;
        try{
            parseId=Long.parseLong(id);
        }
        catch(NumberFormatException e){
            throw new NumberFormatException("Order id "+id+"can not be parsed");
        }
        return ordertoOrderDTO.convert(orderRepository.findById(parseId).orElseThrow(()->new NotFoundException("Record with id"+id+"can not be found")));
    }

    public void saveOrUpdate(OrderDTO orderDTO) {
      orderRepository.save(orderDTOtoOrder.convert(orderDTO));


    }

    public void deleteOrderById(String id) {
        Long parseId;
        try{
            parseId=Long.parseLong(id);
              orderRepository.deleteById(parseId);
        }
        catch(NumberFormatException e){
            throw new NumberFormatException("Order id "+id+"can not be parsed");
        }
        catch(EmptyResultDataAccessException e)
        {
           throw new NotFoundException("Record with id"+id+"can not be found");
        }
    }
}
