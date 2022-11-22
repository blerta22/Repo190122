package com.example.springproject.converters;

import com.example.springproject.dto.CustomerDTO;
import com.example.springproject.model.Customer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CustomerDTOToCustomer implements Converter<CustomerDTO, Customer> {


    @Override
    public Customer convert(CustomerDTO source) {
        if(source!=null){
            Customer customer=new Customer();
            if(source.getId()!=null){
                customer.setId(source.getId());
            }
            customer.setCity(source.getCity());
            customer.setCountry(source.getCountry());
            customer.setAdress1(source.getAdress1());
            customer.setAdress2(source.getAdress2());
            customer.setEmail(source.getEmail());
            customer.setBillingAddress(source.getBillingAddress());
            customer.setCreditCard(source.getCreditCard());
            customer.setDateEntered(source.getDateEntered());
            customer.setFirstName(source.getFirstName());
            customer.setLastName(source.getLastName());
            customer.setPhone(source.getPhone());
            customer.setPostalCode(source.getPostalCode());
            customer.setShippingAddres(source.getShippingAddres());
            customer.setState(source.getState());
         return customer;
        }
       return null;
    }

}
