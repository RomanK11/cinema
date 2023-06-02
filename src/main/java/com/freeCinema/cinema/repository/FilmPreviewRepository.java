package com.freeCinema.cinema.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.freeCinema.cinema.model.FilmPage;
import com.freeCinema.cinema.model.FilmPreview;

public interface FilmPreviewRepository extends CrudRepository<FilmPreview, Long> {
}   