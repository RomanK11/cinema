package com.freeCinema.cinema.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.freeCinema.cinema.model.FilmPage;

public interface FilmPageRepository extends CrudRepository<FilmPage, Long> {
    @Query("SELECT * FROM filmpage WHERE previewid = :pid")
    Iterable<FilmPage> findFilmByPreviewId(@Param("pid") Long previewId);
}