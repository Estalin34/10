package com.example.spring_boot.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;


@Controller
public class AuthController {

    @GetMapping("/login")
    public String getFormLogin() {
        return "login"; // login.html
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.logout(); //Cerrar sesión
        response.sendRedirect("/login?logout");
        return null;

    }

//    @GetMapping("/register")
//    public String register() {
//        return "register"; // Si vas a tener página de registro
//    }
}

