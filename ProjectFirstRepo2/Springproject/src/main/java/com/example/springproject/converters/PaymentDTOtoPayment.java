package com.example.springproject.converters;

import com.example.springproject.dto.PaymentDTO;
import com.example.springproject.model.Payment;
import org.springframework.core.convert.converter.Converter;

public class PaymentDTOtoPayment implements Converter<PaymentDTO, Payment> {


    @Override
    public Payment convert(PaymentDTO source) {
        if(source!=null){
          Payment payment=new Payment();
          if(source.getId()!=null){

           payment.setPaymentType(source.getPaymentType());
           payment.setAllowed(source.isAllowed());
           return payment;

          }
        }
        return null;
    }
}
