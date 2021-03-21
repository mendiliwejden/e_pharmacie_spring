package com.project.e_pharmacie_spring.repositories;

import com.project.e_pharmacie_spring.models.Admin;

public interface AdminRepositoryCustom {
    Admin getUserByName(String name);
}
