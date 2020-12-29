package com.project.e_pharmacie_spring.repositories;

import com.project.e_pharmacie_spring.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>,UserRepositoryCustom {
    
}