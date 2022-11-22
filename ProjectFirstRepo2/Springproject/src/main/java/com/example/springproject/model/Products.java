package com.example.springproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Products extends BaseEntity{
    private String ProductName;
    private String ProductDescription;

    @ManyToOne
    @JoinColumn(name = "supplierId")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn( name = "categoryId")
    private Category category;
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
    private Integer Ranking;
    private String Note;


}

