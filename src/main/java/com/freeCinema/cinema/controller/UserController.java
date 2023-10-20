package com.freeCinema.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.freeCinema.cinema.model.User;
import com.freeCinema.cinema.repository.UserRepository;
import com.freeCinema.cinema.service.InternalServerException;

@Controller
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(path = "/registration")
    public String getQuestionForm() {
        return "registration";
    }

    @GetMapping(path = "/error")
    public String getErrorForm() {
        return "error";
    }

    public boolean existsByField(String fieldValue1, String fieldValue2) {
        return userRepository.findByNameAndPassword(fieldValue1, fieldValue2) != null;
    }

    @PostMapping(path = "/registration")
    public String handleRegistrationForm(@ModelAttribute("user") User user) {
        try {
            if (existsByField(user.getUsername(), user.getPassword()) == false) {
                userRepository.save(user);
            }
        } catch (InternalServerException ex) {
            System.out.println("ex");
        }
        return "jj";
    }

    @ModelAttribute(name = "user")
    public User user() {
        return new User();
    }
}