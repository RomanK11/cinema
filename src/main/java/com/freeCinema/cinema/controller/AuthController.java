package com.freeCinema.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @GetMapping("/auth")
    public String getAuth() {
        return "auth";
    }
}
