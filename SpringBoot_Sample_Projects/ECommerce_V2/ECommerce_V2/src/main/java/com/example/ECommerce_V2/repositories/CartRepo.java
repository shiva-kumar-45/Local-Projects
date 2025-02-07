package com.example.ECommerce_V2.repositories;


import com.example.ECommerce_V2.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart,Long> {

}
