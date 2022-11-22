package com.example.springproject.dto;

import lombok.Data;

@Data
public class CategoryDTO {
    private Long id;
    private String CategoryName;
    private String Description;
    private String picture;
    private Boolean Active;
}
