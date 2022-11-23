package com.example.springproject.restController;

import com.example.springproject.dto.CategoryDTO;
import com.example.springproject.model.Category;
import com.example.springproject.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping
    public List<CategoryDTO> findAll(){
        return categoryService.findAllCategories();
    }
    @GetMapping("/{id}")
    public CategoryDTO findCategoryById(@PathVariable String id){
        return categoryService.findById(id);
    }
    @PostMapping
    public void saveOrUpdate(@RequestBody CategoryDTO categoryDTO){
        categoryService.saveOrUpdate(categoryDTO);

    }
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable String id){
        categoryService.deleteCategoryById(id);
    }

}
