package com.example.springproject.restController;

import com.example.springproject.dto.ProductDTO;
import com.example.springproject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping()
    public List<ProductDTO> findAll(){
        return productService.findAll();
    }
    @GetMapping("/{id}")
    public ProductDTO findProductByID(@PathVariable String id){
        return productService.findById(id);
    }

    @PostMapping
    public void saveOrUpdate(@RequestBody ProductDTO productDTO){
        productService.saveOrUpdate(productDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id){
        productService.deleteProductById(id);

    }





}
