package com.freeCinema.cinema.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.freeCinema.cinema.models.FilmPage;
import com.freeCinema.cinema.models.FilmPreview;

public interface FilmPreviewRepository extends CrudRepository<FilmPreview, Long> {
}   