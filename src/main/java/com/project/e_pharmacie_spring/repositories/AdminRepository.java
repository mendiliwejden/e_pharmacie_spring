package com.project.e_pharmacie_spring.repositories;

import com.project.e_pharmacie_spring.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Integer>,AdminRepositoryCustom  {
}
