package com.example.springproject.services;

import com.example.springproject.converters.SuppliersDTOTOSuppliers;
import com.example.springproject.converters.SuppliersToSuppliersDTO;
import com.example.springproject.dto.SuppliersDTO;
import com.example.springproject.exceptions.NotFoundException;
import com.example.springproject.repositories.SuppliersRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierService {
     private final SuppliersRepository suppliersRepository;
     private final SuppliersToSuppliersDTO toSuppliersDTO;
     private final SuppliersDTOTOSuppliers toSuppliers;

    public SupplierService(SuppliersRepository suppliersRepository, SuppliersToSuppliersDTO toSuppliersDTO, SuppliersDTOTOSuppliers toSuppliers) {
        this.suppliersRepository = suppliersRepository;
        this.toSuppliersDTO = toSuppliersDTO;
        this.toSuppliers = toSuppliers;
    }


    public List<SuppliersDTO> findAll() {
        return suppliersRepository.findAll().stream().map(supplier -> toSuppliersDTO.convert(supplier)).collect(Collectors.toList());
    }

    public SuppliersDTO findSupplierById(String id) {
        Long parseId;
        try{
            parseId = Long.parseLong(id);
        }
        catch(NumberFormatException e){
            throw new NumberFormatException("Supplier id: " + id + " can't be parsed!");
        }

        return  toSuppliersDTO.convert(suppliersRepository.findById(parseId).orElseThrow(()-> new NotFoundException("Record with id:  + id +  not found!")));
    }

    public void saveOrUpdate(SuppliersDTO suppliersDTO) {
        suppliersRepository.save(toSuppliers.convert(suppliersDTO));
    }

    public void deleteSupplierById(String id) {
        try{
            Long parseId = Long.parseLong(id);
            suppliersRepository.deleteById(parseId);
        }
        catch(NumberFormatException e){
            throw new NumberFormatException("Supplier id: " + id + " can't be parsed!");
        }
        catch(EmptyResultDataAccessException e){
            throw new NotFoundException("Record with id "+ id + "not found!");
        }
    }
}
