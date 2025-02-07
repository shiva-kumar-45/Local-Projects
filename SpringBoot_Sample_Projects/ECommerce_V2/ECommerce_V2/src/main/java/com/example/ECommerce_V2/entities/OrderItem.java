package com.example.ECommerce_V2.entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="order_items")

public class OrderItem {

    @Id
    private Long orderItemId;


    private Double orderedProductPrice;

    private Double discount;

    private Integer quantity;

    private Long orderId;

    private Long productId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;




}
