package com.example.ECommerce_V2.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="orders")
public class Order {

    @Column
    @Id
    private Long orderId;

    @Email
    private String email;


    private LocalDate orderDate;


    private String orderStatus;



    private Double totalAmount;


    private Long paymentId;

    @OneToMany(mappedBy = "order", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;




}
