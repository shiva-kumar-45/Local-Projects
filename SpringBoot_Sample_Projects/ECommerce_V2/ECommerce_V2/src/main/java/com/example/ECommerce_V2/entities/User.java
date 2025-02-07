package com.example.ECommerce_V2.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    @Size(min = 5, max = 20, message = "first name length must be in the range of 5 to 20 characters")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "First Name must not contain numbers or special characters")
    private String firstName;

    @Column
    @Size(min = 5, max = 20, message = "lastname length must be in the range of 5 to 20 ")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "First Name must not contain numbers or special characters")
    private String lastName;

    @Column
    @Size(min = 10, max = 10, message = "Mobile Number must be 10 digits")
    private String mobileNumber;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @Column
    private String password;

    @ManyToMany(cascade = { CascadeType.MERGE,CascadeType.PERSIST },fetch= FetchType.EAGER)
    @JoinTable(name="user_role",joinColumns=@JoinColumn(name="userId"),inverseJoinColumns=@JoinColumn(name="roleId"))
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name="user_address",joinColumns=@JoinColumn(name="userId"), inverseJoinColumns = @JoinColumn(name="addressId"))
    private List<Address> addresses = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="user_cart",referencedColumnName = "cartId")
    private Cart cart;










}
