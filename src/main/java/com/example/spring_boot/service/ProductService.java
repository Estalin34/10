package com.example.spring_boot.service;

import com.example.spring_boot.models.Product;
import com.example.spring_boot.repository.ProductRepository;
import com.example.spring_boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProductService {

    @Autowired
    ProductRepository productRepository;

    //Guardar produtos
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    //Listar productos
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    //Obtener id producto
    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }

    //Eliminar producto
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

}

