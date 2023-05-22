package com.example;

import com.example.domain.Genre;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

public interface GenreRepository {
    Optional<Genre> findById(long id);

    Genre save(@NotBlank String name);
}
