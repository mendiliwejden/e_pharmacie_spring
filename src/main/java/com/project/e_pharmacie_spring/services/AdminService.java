package com.project.e_pharmacie_spring.services;


import com.project.e_pharmacie_spring.models.Admin;
import com.project.e_pharmacie_spring.models.UserPrincipal;
import com.project.e_pharmacie_spring.repositories.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements UserDetailsService {
    @Autowired
    AdminRepository adminRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin=adminRepository.getUserByName(username);
        if (admin==null){
            throw new UsernameNotFoundException("admin not found");
        }
        return  new UserPrincipal(admin);
    }
}