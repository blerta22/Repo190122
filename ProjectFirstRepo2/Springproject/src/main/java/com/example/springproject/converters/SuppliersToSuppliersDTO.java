package com.example.springproject.converters;
import com.example.springproject.dto.SuppliersDTO;
import com.example.springproject.model.Supplier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SuppliersToSuppliersDTO implements Converter<Supplier, SuppliersDTO>{

    @Override
    public SuppliersDTO convert(Supplier source) {
        if (source != null){
            SuppliersDTO suppliersDTO = new SuppliersDTO();

            suppliersDTO.setId(source.getId());
            suppliersDTO.setAddress1(source.getAddress1());
            suppliersDTO.setAddress2(source.getAddress2());
            suppliersDTO.setCity(source.getCity());
            suppliersDTO.setCountry(source.getCountry());
            suppliersDTO.setCompanyName(source.getCompanyName());
            suppliersDTO.setContactFName(source.getContactFName());
            suppliersDTO.setContactLName(source.getContactLName());
            suppliersDTO.setPostalCode(source.getPostalCode());
            suppliersDTO.setState(source.getState());
            suppliersDTO.setPhone(source.getPhone());
            suppliersDTO.setEmail(source.getEmail());
            suppliersDTO.setURL(source.getURL());
            suppliersDTO.setCurrentOrder(source.getCurrentOrder());
            suppliersDTO.setPaymentMethods(source.getPaymentMethods());

        }
        return null;
    }
}
