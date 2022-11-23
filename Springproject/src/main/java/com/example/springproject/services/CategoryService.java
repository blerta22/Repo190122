package com.example.springproject.services;

import com.example.springproject.converters.CategoryDTOTOCategory;
import com.example.springproject.converters.CategoryToCategoryDTO;
import com.example.springproject.dto.CategoryDTO;
import com.example.springproject.exceptions.NotFoundException;
import com.example.springproject.model.Category;
import com.example.springproject.repositories.CategoryRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryDTOTOCategory toCategory;
    private final CategoryToCategoryDTO toCategoryDTO;

    public CategoryService(CategoryRepository categoryRepository, CategoryDTOTOCategory toCategory, CategoryToCategoryDTO toCategoryDTO) {
        this.categoryRepository = categoryRepository;
        this.toCategory = toCategory;
        this.toCategoryDTO = toCategoryDTO;
    }

    public List<CategoryDTO> findAllCategories() {
        return categoryRepository.findAll().stream().map(category->toCategoryDTO.convert(category)).collect(Collectors.toList());
    }

    public CategoryDTO findById(String id) {
        Long parseId;
        try {
            parseId = Long.parseLong(id);
        }
            catch(NumberFormatException e){
                throw new NotFoundException("Category id: "+ id + " can't be parsed!");
        }
        return toCategoryDTO.convert(categoryRepository.findById(parseId).orElseThrow(()-> new NotFoundException("Record with id: "+ id + " not found!")));

    }

    public void saveOrUpdate(CategoryDTO categoryDTO) {
        categoryRepository.save(toCategory.convert((categoryDTO)));
    }

    public void deleteCategoryById(String id) {
        try{
           Long parseId = Long.parseLong(id);
           categoryRepository.deleteById(parseId);
        }
        catch(NumberFormatException e){
            throw new NumberFormatException("Category id: "+id+" can't be parsed!");
        }
        catch(EmptyResultDataAccessException e){
            throw new NumberFormatException("Record with id: "+id+" not found!");
        }
    }
}
