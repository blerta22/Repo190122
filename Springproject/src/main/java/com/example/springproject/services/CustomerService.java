package com.example.springproject.services;

import com.example.springproject.converters.CustomerDTOToCustomer;
import com.example.springproject.converters.CustomerToCustomerDTO;
import com.example.springproject.dto.CustomerDTO;
import com.example.springproject.exceptions.NotFoundException;
import com.example.springproject.repositories.CustomerRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDTOToCustomer customerDTOToCustomer;
    private final CustomerToCustomerDTO customerToCustomerDTO;


    public CustomerService(CustomerRepository customerRepository, CustomerDTOToCustomer customerDTOToCustomer, CustomerToCustomerDTO customerToCustomerDTO) {
        this.customerRepository = customerRepository;
        this.customerDTOToCustomer = customerDTOToCustomer;
        this.customerToCustomerDTO = customerToCustomerDTO;
    }


    public List<CustomerDTO> findAll() {
        return customerRepository.findAll().stream().map(customer->customerToCustomerDTO.convert(customer)).collect(Collectors.toList());
    }


    public CustomerDTO findCustomerById(String id) {
        Long parseId;
        try{
            parseId=Long.parseLong(id);
        }
        catch(NumberFormatException e){
            throw new NumberFormatException("Center id: "+id+"can't be parsed");
        }
      return customerToCustomerDTO.convert(customerRepository.findById(parseId).orElseThrow(()->new NotFoundException("Record with id"+parseId+"can not be found")));
    }

    public void deleteCustomerById(String id) {
       Long parseId;
        try{
         parseId=Long.parseLong(id);
            customerRepository.deleteById(parseId);
        }
        catch(NumberFormatException e){
            throw new NumberFormatException("Center id: "+id+"can't be parsed");
        }
        catch(EmptyResultDataAccessException e){
            throw new NotFoundException("\"Record with id\""+ id+"\"can not be found\"");
        }

    }


    public void saveOrUpdate(CustomerDTO customerDTO) {
        customerRepository.save(customerDTOToCustomer.convert(customerDTO));
    }
}
