package com.example.springproject.restController;

import com.example.springproject.dto.CustomerDTO;
import com.example.springproject.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
   private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping({"","/"})
    public List<CustomerDTO> findAll(){
      return customerService.findAll();
    }

    @GetMapping("/{id}")
    public CustomerDTO findCustomerById(@PathVariable String id){
        return customerService.findCustomerById(id);
    }

    @PostMapping
    public void saveorUpdateCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveOrUpdate(customerDTO);
    }



    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable String id){
        customerService.deleteCustomerById(id);
    }




















}
