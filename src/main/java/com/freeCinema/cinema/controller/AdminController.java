package com.freeCinema.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.freeCinema.cinema.model.FilmPage;
import com.freeCinema.cinema.model.FilmPreview;
import com.freeCinema.cinema.model.User;
import com.freeCinema.cinema.repository.FilmPageRepository;
import com.freeCinema.cinema.repository.FilmPreviewRepository;
import com.freeCinema.cinema.repository.UserRepository;
import com.freeCinema.cinema.service.InternalServerException;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FilmPreviewRepository filmPreviewRepository;

    public boolean existsByField(String fieldValue1, String fieldValue2, String fieldValue3) {
        return filmPreviewRepository.searchFilmsByAllArgs(fieldValue1, fieldValue2, fieldValue3) != null;
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "adminUsers";
    }

    @GetMapping("/add-film")
    public String getFilms(Model film) {
        Iterable<FilmPreview> films = filmPreviewRepository.findAll();
        film.addAttribute("films", films);
        return "adminFilms";
    }

    @PostMapping(path = "/add-film")
    public String handleAddForm(@ModelAttribute("film") FilmPreview film) {
        filmPreviewRepository.save(film);
        return "jj";
    }

    @ModelAttribute(name = "film")
    public FilmPreview film() {
        return new FilmPreview();
    }
}