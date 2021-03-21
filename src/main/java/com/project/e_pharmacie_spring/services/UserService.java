package com.project.e_pharmacie_spring.services;

import com.project.e_pharmacie_spring.models.User;
import com.project.e_pharmacie_spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {
        return repository.save(user);
    }

    public List<User> listAll() {
        return repository.findAll();
    }

    public User getUserById(int id) {
        return repository.getOne(id);
    }

    public User getUserByName(String name) {
        return repository.getUserByName(name);
    }

    public void deleteAll() {
        repository.deleteAll();  
    }

    public void deleteUser( int id) {
        try {
            repository.deleteById(id);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public User updateUser( User user) {
        User existingUser = repository.getOne(user.getId());
        existingUser.setName(user.getName());
        existingUser.setMail(user.getMail());
        existingUser.setPassword(user.getPassword());
        existingUser.setNumber(user.getNumber());
        return existingUser;
    }

    
}