package com.project.e_pharmacie_spring.repositories;


import com.project.e_pharmacie_spring.models.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandRepository extends JpaRepository<Command,Integer>,CommandRepositoryCustom {
    
}