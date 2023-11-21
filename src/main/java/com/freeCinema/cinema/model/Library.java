package com.freeCinema.cinema.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("library")
public class Library {
    @Id
    private Long id;

    private Long preview_id;

    private String title;
}
