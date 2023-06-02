package com.freeCinema.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.freeCinema.cinema.model.FilmPreview;
import com.freeCinema.cinema.repository.FilmPreviewRepository;

@Controller
public class FilmPreviewPageController {

    @Autowired
    private FilmPreviewRepository FilmPreviewRepository;  // репозиторий для работы с базой данных

    @GetMapping("/catalog")
    public String getAllVideos(Model catalog) {
        Iterable<FilmPreview> previews = FilmPreviewRepository.findAll();
        catalog.addAttribute("previews", previews);
        return "catalogPage";  // название HTML страницы
    }
}