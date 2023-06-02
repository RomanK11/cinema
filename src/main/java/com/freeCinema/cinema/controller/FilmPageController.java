package com.freeCinema.cinema.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.freeCinema.cinema.model.FilmPage;
import com.freeCinema.cinema.repository.FilmPageRepository;

@Controller
@RequestMapping(path = "/film")
public class FilmPageController {

    @Autowired
    private FilmPageRepository filmPageRepository;  // репозиторий для работы с базой данных

    @GetMapping("/{id}")
    public String getVideo() {
        return "filmPage";
    }

    @GetMapping("/videos/{id}")
    public String getAllVideos(@PathVariable("id") Long previewId, Model model) {
        Optional<FilmPage> videos = filmPageRepository.findById(previewId);
        ArrayList<FilmPage> res = new ArrayList<>();
        videos.ifPresent(res::add);
        model.addAttribute("videos", res);
        return "filmPage";  // название HTML страницы
    }

    @ModelAttribute(name = "film")
    public FilmPage film() { 
        return new FilmPage();
    }
}