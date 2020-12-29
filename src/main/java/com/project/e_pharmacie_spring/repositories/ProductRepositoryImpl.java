package com.project.e_pharmacie_spring.repositories;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.project.e_pharmacie_spring.models.Product;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional(readOnly = true)
public class ProductRepositoryImpl implements ProductRepositoryCustom {

    @PersistenceContext
    EntityManager entity;

    @Override
    public List<Product> listProductByCategory(String category) {
        Query query=entity.createNativeQuery("SELECT v.* FROM product v WHERE v.category=?",Product.class);
        query.setParameter(1,category);
        return (List<Product>) query.getResultList();
    }

    
}