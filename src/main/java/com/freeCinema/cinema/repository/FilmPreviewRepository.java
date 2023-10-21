package com.freeCinema.cinema.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.freeCinema.cinema.model.FilmPreview;

public interface FilmPreviewRepository extends CrudRepository<FilmPreview, Long> {
    @Query("SELECT * FROM FILMPREVIEW WHERE TITLE = :title")
    Iterable<FilmPreview> searchFilms(@Param("title") String title);

    @Query("SELECT * FROM filmpreview WHERE TITLE = :title AND PICTURE = :picture AND THEME = :theme")
    Iterable<FilmPreview> searchFilmsByAllArgs(@Param("title") String title, @Param("picture") String picture,
            @Param("theme") String theme);
}