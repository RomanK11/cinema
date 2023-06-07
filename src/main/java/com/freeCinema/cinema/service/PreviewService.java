package com.freeCinema.cinema.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freeCinema.cinema.model.FilmPreview;
import com.freeCinema.cinema.repository.FilmPreviewRepository;

@Service
public class PreviewService {
    @Autowired
    private FilmPreviewRepository previewRepository;
    
    public Iterable<FilmPreview> searchFilms(String title) {
        return previewRepository.searchFilms(title);
    }
}