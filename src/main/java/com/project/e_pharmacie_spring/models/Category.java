package com.project.e_pharmacie_spring.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "libelle")
    private String libelle;

    @OneToMany(mappedBy = "category")
    private List<Product> product=new ArrayList<Product>();
    
}