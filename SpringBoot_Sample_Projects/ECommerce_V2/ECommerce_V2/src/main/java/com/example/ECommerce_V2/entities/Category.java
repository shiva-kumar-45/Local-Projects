package com.example.ECommerce_V2.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="categories")
public class Category {

    @Id
    private Long categoryId;

    private String categoryName;

    @OneToMany(mappedBy = "category", cascade =  CascadeType.ALL )
    private List<Product> products;


}
