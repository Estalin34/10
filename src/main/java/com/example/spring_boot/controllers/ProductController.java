package com.example.spring_boot.controllers;

import com.example.spring_boot.models.Product;
import com.example.spring_boot.service.ProductService;
import com.example.spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;

    // Página para añadir un producto
    @GetMapping("/add")
    public String getFormProduct(Model model) {
        model.addAttribute("product", new Product());
        return "crud";
    }

    // Guardar un nuevo producto
    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);  // Guardar el producto
        return "redirect:/";  // Redireccionar a la página principal
    }

    // Página principal con la lista de productos
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "home";
    }

    // Página para editar un producto existente
    @GetMapping("/product/edit/{id}")
    public String getFormEditProduct(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id).orElseThrow();
        model.addAttribute("product", product);
        return "crud";
    }

    // Guardar los cambios al producto editado
    @PostMapping("/product/edit/{id}")
    public String editProduct(@PathVariable Long id, @ModelAttribute Product product) {
        product.setId(id);
        productService.saveProduct(product);
        return "redirect:/";
    }

    // Eliminar un producto
    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }
    @PostMapping("/user/{userId}/add-product/{productId}")
    public ResponseEntity<String> assignProductToUser(@PathVariable Long userId, @PathVariable Long productId) {
        userService.addProductToUser(userId, productId);
        return ResponseEntity.ok("Producto asignado correctamente al usuario");
    }

}

