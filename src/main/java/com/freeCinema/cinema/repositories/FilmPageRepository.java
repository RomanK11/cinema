package com.freeCinema.cinema.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.freeCinema.cinema.models.FilmPage;

public interface FilmPageRepository extends CrudRepository<FilmPage, Long> {
    @Query("SELECT * FROM FILMS WHERE PREVIEW_ID = :pid")
    Iterable<FilmPage> findFilmByPreviewId(@Param("pid") Long previewId);
}    