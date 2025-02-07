package com.example.ECommerce_V2.repositories;

import com.example.ECommerce_V2.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {


}
