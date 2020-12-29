package com.project.e_pharmacie_spring.repositories;

import com.project.e_pharmacie_spring.models.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    
}