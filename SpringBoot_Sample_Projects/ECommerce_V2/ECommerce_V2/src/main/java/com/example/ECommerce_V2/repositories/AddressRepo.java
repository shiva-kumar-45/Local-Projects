package com.example.ECommerce_V2.repositories;

import com.example.ECommerce_V2.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepo extends JpaRepository<Address,Long> {


}
