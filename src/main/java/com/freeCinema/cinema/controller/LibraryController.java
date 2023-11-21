package com.freeCinema.cinema.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.freeCinema.cinema.model.FilmPage;
import com.freeCinema.cinema.model.FilmPreview;
import com.freeCinema.cinema.model.Library;
import com.freeCinema.cinema.model.User;
import com.freeCinema.cinema.repository.FilmPageRepository;
import com.freeCinema.cinema.repository.FilmPreviewRepository;
import com.freeCinema.cinema.repository.LibraryRepository;

@Controller
public class LibraryController {

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private FilmPreviewRepository filmPreviewRepository;

    @GetMapping("/add/{id}/{title}")
    public String getAddPage(@PathVariable("id") Long id, Model catalog) {
        Iterable<FilmPreview> previews = filmPreviewRepository.searchById(id);
        catalog.addAttribute("previews", previews);
        return "addPage";
        // work
    }

    @PostMapping("/add/{id}/{title}")
    public String setVideoPage(@PathVariable("id") Long id, @PathVariable("title") String title,
            Model model, @ModelAttribute("lib") Library lib) {
        lib.setId(null);
        lib.setPreview_id(id);
        lib.setTitle(title);
        libraryRepository.save(lib);
        return "jj"; // название HTML страницы

    }

    @ModelAttribute(name = "lib")
    public Library lib() {
        return new Library();
    }
}
