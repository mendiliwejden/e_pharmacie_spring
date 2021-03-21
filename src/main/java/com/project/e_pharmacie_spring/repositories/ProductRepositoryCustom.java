package com.project.e_pharmacie_spring.repositories;

import java.util.List;

import com.project.e_pharmacie_spring.models.Category;
import com.project.e_pharmacie_spring.models.Product;

public interface ProductRepositoryCustom {
    List<Product> listProductByCategory(Category category);
}
