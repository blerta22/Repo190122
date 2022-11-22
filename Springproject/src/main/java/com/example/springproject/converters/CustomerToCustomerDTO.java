package com.example.springproject.converters;

import com.example.springproject.dto.CustomerDTO;
import com.example.springproject.model.Customer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CustomerToCustomerDTO implements Converter<Customer, CustomerDTO> {


    @Override
    public CustomerDTO convert(Customer source) {

        if(source!=null){

         CustomerDTO customerDTO=new CustomerDTO() ;
         customerDTO.setId(source.getId());
         customerDTO.setCity(source.getCity());
         customerDTO.setCountry(source.getCountry());
         customerDTO.setAdress1(source.getAdress1());
         customerDTO.setAdress2(source.getAdress2());
         customerDTO.setEmail(source.getEmail());
         customerDTO.setBillingAddress(source.getBillingAddress());
         customerDTO.setCreditCard(source.getCreditCard());
         customerDTO.setDateEntered(source.getDateEntered());
         customerDTO.setFirstName(source.getFirstName());
         customerDTO.setLastName(source.getLastName());
         customerDTO.setPhone(source.getPhone());
         customerDTO.setPostalCode(source.getPostalCode());
         customerDTO.setShippingAddres(source.getShippingAddres());
         customerDTO.setState(source.getState());
         return customerDTO;
        }
        return null;
    }
}
