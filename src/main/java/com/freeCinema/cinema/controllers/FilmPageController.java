package com.freeCinema.cinema.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.freeCinema.cinema.models.FilmPage;
import com.freeCinema.cinema.repositories.FilmPageRepository;

@Controller
public class FilmPageController {

    @Autowired
    private FilmPageRepository filmPageController;  // репозиторий для работы с базой данных

    @GetMapping("/videos")
    public String getAllVideos(Model model) {
        Iterable<FilmPage> videos = filmPageController.findAll();
        model.addAttribute("videos", videos);
        return "filmPage";  // название HTML страницы
    }
}