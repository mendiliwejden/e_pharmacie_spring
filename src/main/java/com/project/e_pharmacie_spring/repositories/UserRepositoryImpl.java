package com.project.e_pharmacie_spring.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.project.e_pharmacie_spring.models.User;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    EntityManager entity;

    @Override
    public User getUserByName(String name) {
        Query query=entity.createNativeQuery("SELECT u.* FROM user u WHERE u.name = ?",User.class);
        query.setParameter(1, name);
        return (User) query.getSingleResult();
    }
}