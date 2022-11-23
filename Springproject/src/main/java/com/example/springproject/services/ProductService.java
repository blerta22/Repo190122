package com.example.springproject.services;

import com.example.springproject.converters.ProductDTOtoProduct;
import com.example.springproject.converters.ProductToProductDTO;
import com.example.springproject.dto.ProductDTO;
import com.example.springproject.exceptions.NotFoundException;
import com.example.springproject.repositories.ProductsRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductsRepository productsRepository;
    private final ProductDTOtoProduct productDTOtoProduct;
    private final ProductToProductDTO toProductDTO;

    public ProductService(ProductsRepository productsRepository, ProductDTOtoProduct productDTOtoProduct, ProductToProductDTO toProductDTO) {
        this.productsRepository = productsRepository;
        this.productDTOtoProduct = productDTOtoProduct;
        this.toProductDTO = toProductDTO;
    }

    public List<ProductDTO> findAll() {
        return productsRepository.findAll().stream().map(product -> toProductDTO.convert(product)).collect(Collectors.toList());
    }

    public ProductDTO findById(String id) {

        Long parseId;
        try{
            parseId = Long.parseLong(id);
        }
        catch(NumberFormatException e){
            throw new NumberFormatException("Product id: " + id +" can't be parsed!");
        }

        return toProductDTO.convert(productsRepository.findById(parseId).orElseThrow(()-> new NotFoundException("Record with id: "+id+ " not found!")));

    }

    public void saveOrUpdate(ProductDTO productDTO) {

        productsRepository.save(productDTOtoProduct.convert(productDTO));
    }


    public void deleteProductById(String id) {
        try{
        Long parseId = Long.parseLong(id);
        productsRepository.deleteById(parseId);
        }
        catch (NumberFormatException e){
            throw new NumberFormatException("Product id: " + id +" can't be parsed!");
        }
        catch(EmptyResultDataAccessException e){
            throw new NotFoundException("Record with id: "+ id + " not found!");
        }

    }
}
