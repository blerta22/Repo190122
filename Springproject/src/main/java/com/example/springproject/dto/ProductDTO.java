package com.example.springproject.dto;

import lombok.Data;

import javax.persistence.Lob;

@Data
public class ProductDTO {
    private Long id;
    private String ProductName;
    private String ProductDescription;
    private Integer QuantityPerUnit;
    private Integer UnitPrice;
    private Integer AvailableSize;
    private Integer AvailableColors;
    private String Size;
    private String Color;
    private String Discount;
    private Integer UnitWeight;
    private Integer UnitsInStock;
    private Integer UnitsOnOrder;
    private String ProductAvailable;
    @Lob
    private Byte[] Image;

    private Long CategoryId;
    private Long SupplierId;


}
