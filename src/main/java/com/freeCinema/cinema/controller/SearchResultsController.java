package com.freeCinema.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchResultsController {
    @GetMapping
    public String getResults() {
        return "search-results";
    }
    
}
