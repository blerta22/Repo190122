package com.example.springproject.converters;

import com.example.springproject.dto.PaymentDTO;
import com.example.springproject.model.Payment;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PaymenttoPaymentDTO implements Converter<Payment, PaymentDTO> {


    @Override
    public PaymentDTO convert(Payment source) {
        if(source!=null){
         PaymentDTO paymentDTO=new PaymentDTO();
         paymentDTO.setId(source.getId());
         paymentDTO.setPaymentType(source.getPaymentType());
         paymentDTO.setAllowed(source.isAllowed());
           return paymentDTO;

        }
        return null;
    }
}
