package com.freeCinema.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.freeCinema.cinema.model.User;
import com.freeCinema.cinema.service.AuthService;

@Controller
public class LoginController {
    private final AuthService authService;

    @Autowired
    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String authenticate(@RequestParam String username, @RequestParam String password) {
        if (authService.authenticate(username, password)) {
            return "loginSucces";
        } else {
            return "error";
        }
    }

    @ModelAttribute(name = "user")
    public User user() {
        return new User();
    }
}