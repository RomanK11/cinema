package com.freeCinema.cinema.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("FILMS")
public class FilmPage {
    @Id
    private Integer id;

    private Long previewId;

    private String title;

    private String link;
}