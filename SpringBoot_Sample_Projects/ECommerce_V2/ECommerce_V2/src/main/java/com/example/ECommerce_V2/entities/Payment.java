package com.example.ECommerce_V2.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="payments")
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentID;

    @Column
    @NotBlank
    private String paymentMethod;

    @OneToOne(mappedBy = "payment" , cascade = CascadeType.ALL)
    private Order order;
}
