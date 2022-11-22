package com.example.springproject.converters;
import com.example.springproject.dto.CategoryDTO;
import com.example.springproject.model.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryDTO implements Converter<Category, CategoryDTO>{

    @Override
    public CategoryDTO convert(Category source) {
        if (source != null){
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(source.getId());
            categoryDTO.setCategoryName(source.getCategoryName());
            categoryDTO.setDescription(source.getDescription());
            categoryDTO.setActive(source.getActive());
            categoryDTO.setPicture(source.getPicture());
        }
        return null;
    }
}
