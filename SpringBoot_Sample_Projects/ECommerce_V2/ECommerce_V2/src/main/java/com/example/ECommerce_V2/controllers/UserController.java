package com.example.ECommerce_V2.controllers;


import com.example.ECommerce_V2.dto.UserDTO;
import com.example.ECommerce_V2.entities.User;
import com.example.ECommerce_V2.repositories.UserRepo;
import com.example.ECommerce_V2.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {


    private UserService userService;

    @GetMapping("/user/getUser/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long userId ){
        UserDTO user =  userService.getUserById(userId);
        return new ResponseEntity<UserDTO>(user,HttpStatus.FOUND);
    }




}
