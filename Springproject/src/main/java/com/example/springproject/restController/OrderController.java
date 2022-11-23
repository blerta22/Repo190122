package com.example.springproject.restController;


import com.example.springproject.dto.OrderDTO;
import com.example.springproject.services.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }



    @GetMapping({"","/"})
    public List<OrderDTO> findAll(){
        return orderService.findAll();
    }


    @GetMapping("/{id}")
    public OrderDTO findOrderById(@PathVariable String id){
      return orderService.findOrderById(id);
    }

    @PostMapping
    public void saveorUpdate(@RequestBody OrderDTO orderDTO){
        orderService.saveOrUpdate(orderDTO);
    }


    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable String id){
        orderService.deleteOrderById(id);
    }





}
