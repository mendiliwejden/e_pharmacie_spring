package com.project.e_pharmacie_spring.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "command")
public class Command {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="date")
	private Date date_command;

	@Column(name="price")
    private double price;
    
    @Column(name="description")
    private String descritpion;

    //@OneToMany(mappedBy="user_id")
    @ManyToOne
	@JoinColumn(name="user_id",nullable = false)
	private  User user;
	
    //@OneToMany(mappedBy="product_id")
    @ManyToMany
    private List<Product> product=new ArrayList<Product>();
/////////////////////////////////////Getters setters/////////////////////
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Date getDate_command() {
        return date_command;
    }

    public void setDate_command(final Date date_command) {
        this.date_command = date_command;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }
    

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    

    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
    
    

    
}