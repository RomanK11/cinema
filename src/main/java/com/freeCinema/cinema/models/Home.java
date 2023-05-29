package com.freeCinema.cinema.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Table("TEST")
public class Home {
    @Id
    private Long id;

    private String email;

    private String password;

    private String username;

    private Integer age;
}