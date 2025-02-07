package com.example.ECommerce_V2.controllers;


import com.example.ECommerce_V2.dto.UserDTO;
import com.example.ECommerce_V2.services.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    private UserService userService;


    @PostMapping("/register")
    public void registerHandler(@Valid @RequestBody UserDTO user)  {

        String



    }
}
