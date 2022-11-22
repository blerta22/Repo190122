package com.example.springproject.converters;

import com.example.springproject.dto.CategoryDTO;
import com.example.springproject.model.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryDTOTOCategory implements Converter<CategoryDTO, Category>{

    @Override
    public Category convert(CategoryDTO source) {
        if (source != null) {
            Category category = new Category();
            if (source.getId()!= null) {
                category.setId(source.getId());
                category.setCategoryName(source.getCategoryName());
                category.setDescription(source.getDescription());
                category.setActive(source.getActive());
                category.setPicture(source.getPicture());
            }
        }
                return null;

    }
}
