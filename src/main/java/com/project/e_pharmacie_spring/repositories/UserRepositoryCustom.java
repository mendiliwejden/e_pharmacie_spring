package com.project.e_pharmacie_spring.repositories;

import com.project.e_pharmacie_spring.models.User;

public interface UserRepositoryCustom {
    User getUserByName(String name);

}
