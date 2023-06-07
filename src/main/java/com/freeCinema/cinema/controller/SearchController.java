package com.freeCinema.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.freeCinema.cinema.model.FilmPreview;
import com.freeCinema.cinema.service.PreviewService;

@Controller
public class SearchController {
    @Autowired
    private PreviewService previewService;
    
    @GetMapping("/search")
    public String getVideo() {
        return "search";
    }

    @PostMapping("/search")
    public String searchBooks(@RequestParam("title") String title, Model model) {
        Iterable<FilmPreview> books = previewService.searchFilms(title);
        model.addAttribute("books", books);
        return "search-results";
    }
}