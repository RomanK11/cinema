package com.freeCinema.cinema.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Table("FILMPREVIEW")
public class FilmPreview {
    @Id
    private Integer id;

    private String title;

    private String picture;

    private String theme;
}