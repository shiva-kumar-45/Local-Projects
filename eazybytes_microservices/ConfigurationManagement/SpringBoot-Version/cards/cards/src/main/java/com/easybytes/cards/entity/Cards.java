package com.easybytes.cards.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cards extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;

    @Column(name="mobile_number")
    private String mobileNumber;

    @Column(name="card_number")
    private String cardNumber;

    @Column(name="card_type")
    private String cardType;

    @Column(name="total_limit")
    private Integer totalLimit;

    @Column(name="amount_used")
    private Integer amountUsed;

    @Column(name="available_amount")
    private Integer availableAmount;

}
