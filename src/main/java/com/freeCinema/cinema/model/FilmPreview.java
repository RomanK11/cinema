package com.freeCinema.cinema.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("filmpreview")
public class FilmPreview {
    @Id
    private Integer id;

    private String title;

    private String picture;

    private String theme;
}