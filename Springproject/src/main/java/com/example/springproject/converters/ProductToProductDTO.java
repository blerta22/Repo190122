package com.example.springproject.converters;

import com.example.springproject.dto.ProductDTO;
import com.example.springproject.model.Products;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductToProductDTO implements Converter< Products, ProductDTO>  {

    @Override
    public ProductDTO convert(Products source) {
        if(source!= null){
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(source.getId());
        productDTO.setProductAvailable(source.getProductAvailable());
        productDTO.setProductName(source.getProductName());
        productDTO.setColor(source.getColor());
        productDTO.setProductDescription(source.getProductDescription());
        productDTO.setAvailableColors(source.getAvailableColors());
        productDTO.setColor(source.getColor());
        productDTO.setAvailableSize(source.getAvailableSize());
        productDTO.setSize(source.getSize());
        productDTO.setQuantityPerUnit(source.getQuantityPerUnit());
        productDTO.setUnitPrice(source.getUnitPrice());
        productDTO.setDiscount(source.getDiscount());
        productDTO.setUnitWeight(source.getUnitWeight());
        productDTO.setUnitsOnOrder(source.getUnitsOnOrder());
        productDTO.setUnitsInStock(source.getUnitsInStock());
        productDTO.setCategoryId(source.getCategory().getId());
        productDTO.setSupplierId(source.getSupplier().getId());



        return productDTO;
        }

        return null;
    }
}
