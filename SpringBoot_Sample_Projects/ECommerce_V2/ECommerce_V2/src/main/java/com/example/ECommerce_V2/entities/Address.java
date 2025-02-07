package com.example.ECommerce_V2.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="addresses")
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @Column
    @NotBlank
    @Size(min=5,message="Bulding name must be more than 5 letters")
    private String buildingName;
    @NotBlank
    @Size(min=5,message="city atleasr 5 characters")
    @Column
    private String city;
    @NotBlank
    @Size(min=4,message="Atleast 4 characters")
    @Column
    private String country;
    @Column
    @NotBlank
    private String pinCode;
    @Column
    @NotBlank
    private String state;
    @Column
    @NotBlank
    private String street;

    @ManyToMany(mappedBy="addresses")
    private List<User> users = new ArrayList<>();

    public Address(String country, String state, String city, String pinCode, String street, String buildingName) {
        this.country = country;
        this.state = state;
        this.city = city;
        this.pinCode = pinCode;
        this.street = street;
        this.buildingName = buildingName;
    }

}
