package com.example.springproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Shipper extends BaseEntity{
    private String CompanyName;
    private String Phone;

    @OneToMany(mappedBy = "shipper",cascade = CascadeType.ALL)
    private Set<Order> orders=new HashSet<>();

}
