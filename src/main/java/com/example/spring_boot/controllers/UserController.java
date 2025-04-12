package com.example.spring_boot.controllers;

import com.example.spring_boot.models.User;
import com.example.spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/register")
    public String getFormRegister(Model model) {
        model.addAttribute("user", new User());
        return "register"; //template
    }

    @PostMapping("/register")
    public RedirectView registerUser(@ModelAttribute User user) {
        this.service.save(user);
        return new RedirectView("/login") ;
    }
}
