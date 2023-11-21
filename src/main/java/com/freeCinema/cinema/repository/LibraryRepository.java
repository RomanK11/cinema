package com.freeCinema.cinema.repository;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.freeCinema.cinema.model.FilmPage;
import com.freeCinema.cinema.model.Library;

public interface LibraryRepository extends CrudRepository<Library, Long> {
    @Query("SELECT * FROM library WHERE preview_id = :pid AND title = :title")
    Iterable<Library> findByIdAndTitle(@Param("pid") Long preview_id, @Param("title") String title);
}
