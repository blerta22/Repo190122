package com.example.springproject.restController;

import com.example.springproject.dto.SuppliersDTO;
import com.example.springproject.services.SupplierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public List<SuppliersDTO> findAll(){
       return supplierService.findAll();
    }

    @GetMapping("/{id}")
    public SuppliersDTO findSupplierById(@PathVariable String id){
        return supplierService.findSupplierById(id);
    }
    @PostMapping
    public void saveOrUpdate(@RequestBody SuppliersDTO suppliersDTO){
        supplierService.saveOrUpdate(suppliersDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteSupplier(@PathVariable String id){

        supplierService.deleteSupplierById(id);

    }

}
