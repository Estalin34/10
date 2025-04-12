package com.example.spring_boot.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
public class User {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String last;
    private String email;
    @Column(unique = true)
    private String username;
    private String password;
    // Lista de productos asociados a este usuario
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_product",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
