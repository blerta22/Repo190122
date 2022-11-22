package com.example.springproject.converters;
import com.example.springproject.dto.SuppliersDTO;
import com.example.springproject.model.Supplier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SuppliersDTOTOSuppliers implements Converter<SuppliersDTO, java.util.function.Supplier>{

    @Override
    public java.util.function.Supplier convert(SuppliersDTO source) {
        if (source != null){
            Supplier suppliers = new Supplier();
            if (source.getId()!= null){
                suppliers.setId(source.getId());
                suppliers.setAddress1(source.getAddress1());
                suppliers.setAddress2(source.getAddress2());
                suppliers.setCity(source.getCity());
                suppliers.setCountry(source.getCountry());
                suppliers.setCompanyName(source.getCompanyName());
                suppliers.setContactFName(source.getContactFName());
                suppliers.setContactLName(source.getContactLName());
                suppliers.setPostalCode(source.getPostalCode());
                suppliers.setState(source.getState());
                suppliers.setPhone(source.getPhone());
                suppliers.setEmail(source.getEmail());
                suppliers.setURL(source.getURL());
                suppliers.setCurrentOrder(source.getCurrentOrder());
                suppliers.setPaymentMethods(source.getPaymentMethods());
            }
        }
        return null;
    }
}
