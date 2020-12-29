package com.project.e_pharmacie_spring.repositories;

import java.util.List;

import com.project.e_pharmacie_spring.models.Command;
import com.project.e_pharmacie_spring.models.Product;
import com.project.e_pharmacie_spring.models.User;

public interface CommandRepositoryCustom {
    List<Command> listCommandByProduct(Product product);
    List<Command> listCommandByUser(User user);

    
}