package com.example.ECommerce_V2.entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="cart_items")
public class CartItem {

    @Id
    private Long cartItemId;

    private Double productPrice;

    private Double discount;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;





}
