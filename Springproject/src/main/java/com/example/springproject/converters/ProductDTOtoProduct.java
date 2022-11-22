package com.example.springproject.converters;

import com.example.springproject.dto.ProductDTO;
import com.example.springproject.model.Products;
import com.example.springproject.repositories.CategoryRepository;
import com.example.springproject.repositories.SuppliersRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductDTOtoProduct implements Converter<ProductDTO, Products> {

    private final CategoryRepository categoryRepository;
    private final SuppliersRepository suppliersRepository;

    public ProductDTOtoProduct(CategoryRepository categoryRepository, SuppliersRepository suppliersRepository) {
        this.categoryRepository = categoryRepository;
        this.suppliersRepository = suppliersRepository;
    }


    @Override
    public Products convert(ProductDTO source) {
        if (source != null) {
            Products products = new Products();
            if (source.getId() != null) {
                products.setId(source.getId());
                products.setProductAvailable(source.getProductAvailable());
                products.setProductName(source.getProductName());
                products.setColor(source.getColor());
                products.setProductDescription(source.getProductDescription());
                products.setAvailableColors(source.getAvailableColors());
                products.setColor(source.getColor());
                products.setAvailableSize(source.getAvailableSize());
                products.setSize(source.getSize());
                products.setQuantityPerUnit(source.getQuantityPerUnit());
                products.setUnitPrice(source.getUnitPrice());
                products.setDiscount(source.getDiscount());
                products.setUnitWeight(source.getUnitWeight());
                products.setUnitsOnOrder(source.getUnitsOnOrder());
                products.setUnitsInStock(source.getUnitsInStock());
                products.setCategory(categoryRepository.findById(source.getCategoryId()).get());
                products.setSupplier(suppliersRepository.findById(source.getSupplierId()).get());


                return products;

            }
        }
            return null;
        }
    }
