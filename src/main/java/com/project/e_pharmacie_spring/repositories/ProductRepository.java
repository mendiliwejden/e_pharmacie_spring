package com.project.e_pharmacie_spring.repositories;

import com.project.e_pharmacie_spring.models.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer>,ProductRepositoryCustom {
    
}