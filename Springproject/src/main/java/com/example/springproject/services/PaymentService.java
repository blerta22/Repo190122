package com.example.springproject.services;

import com.example.springproject.converters.PaymentDTOtoPayment;
import com.example.springproject.converters.PaymenttoPaymentDTO;
import com.example.springproject.dto.PaymentDTO;
import com.example.springproject.exceptions.NotFoundException;
import com.example.springproject.repositories.PaymentRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentDTOtoPayment paymentDTOtoPayment;
    private final PaymenttoPaymentDTO paymenttoPaymentDTO;

    public PaymentService(PaymentRepository paymentRepository, PaymentDTOtoPayment paymentDTOtoPayment, PaymenttoPaymentDTO paymenttoPaymentDTO) {
        this.paymentRepository = paymentRepository;
        this.paymentDTOtoPayment = paymentDTOtoPayment;
        this.paymenttoPaymentDTO = paymenttoPaymentDTO;
    }


    public List<PaymentDTO> findAll() {
      return paymentRepository.findAll().stream().map(payment->paymenttoPaymentDTO.convert(payment)).collect(Collectors.toList());

    }



    public PaymentDTO findPaymentById(String id) {
        Long parseid;
        try{
            parseid=Long.parseLong(id);
        }
        catch(NumberFormatException e){
            throw new NumberFormatException("Payment id "+id+" can not be parsed");
        }
        return paymenttoPaymentDTO.convert(paymentRepository.findById(parseid).orElseThrow(()->new NotFoundException("Record with id"+id+"not found")));
    }


    public void saveOrUpdate(PaymentDTO paymentDTO) {
        paymentRepository.save(paymentDTOtoPayment.convert(paymentDTO));
    }


    public void deletePaymentById(String id) {
        Long parseId;
        try{
            parseId=Long.parseLong(id);
            paymentRepository.deleteById(parseId);

        }
        catch(NumberFormatException e){
            throw new NumberFormatException("Payment id"+id+"can not be parsed");
        }
        catch(EmptyResultDataAccessException e){
            throw new NotFoundException("Record with id"+id+"not found");

        }
    }
}
