package com.example.springproject.restController;

import com.example.springproject.dto.PaymentDTO;
import com.example.springproject.services.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping({"","/"})
    public List<PaymentDTO> findAll(){
        return paymentService.findAll();
    }
    @GetMapping("/{id}")
    public PaymentDTO findPaymentById(@PathVariable String id){
        return paymentService.findPaymentById(id);

    }
    @PostMapping
    public void saveOrUpdate(@RequestBody PaymentDTO paymentDTO){
        paymentService.saveOrUpdate(paymentDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePaymentById(@PathVariable String id){
        paymentService.deletePaymentById(id);

    }
}
