package com.example.springproject.converters;

import com.example.springproject.dto.ProductDTO;
import com.example.springproject.model.Product;
import com.example.springproject.repositories.CategoryRepository;
import com.example.springproject.repositories.SuppliersRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductDTOtoProduct implements Converter<ProductDTO, Product> {

    private final CategoryRepository categoryRepository;
    private final SuppliersRepository suppliersRepository;

    public ProductDTOtoProduct(CategoryRepository categoryRepository, SuppliersRepository suppliersRepository) {
        this.categoryRepository = categoryRepository;
        this.suppliersRepository = suppliersRepository;
    }


    @Override
    public Product convert(ProductDTO source) {
        if (source != null) {
            Product product = new Product();
            if (source.getId() != null) {
                product.setId(source.getId());
                product.setProductAvailable(source.getProductAvailable());
                product.setProductName(source.getProductName());
                product.setColor(source.getColor());
                product.setProductDescription(source.getProductDescription());
                product.setAvailableColors(source.getAvailableColors());
                product.setColor(source.getColor());
                product.setAvailableSize(source.getAvailableSize());
                product.setSize(source.getSize());
                product.setQuantityPerUnit(source.getQuantityPerUnit());
                product.setUnitPrice(source.getUnitPrice());
                product.setDiscount(source.getDiscount());
                product.setUnitWeight(source.getUnitWeight());
                product.setUnitsOnOrder(source.getUnitsOnOrder());
                product.setUnitsInStock(source.getUnitsInStock());
                product.setCategory(categoryRepository.findById(source.getCategoryId()).get());
                product.setSupplier(suppliersRepository.findById(source.getSupplierId()).get());


                return product;

            }
        }
            return null;
        }
    }
