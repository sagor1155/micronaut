package com.example;

import com.example.domain.Genre;
import io.micronaut.transaction.annotation.TransactionalAdvice;
import jakarta.inject.Singleton;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Singleton
@TransactionalAdvice
public class GenreRepositoryImpl implements GenreRepository {

    private final EntityManager entityManager;

    public GenreRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Genre> findById(long id) {
        return Optional.ofNullable(entityManager.find(Genre.class, id));
    }

    @Override
    public Genre save(@NotBlank String name) {
        Genre genre = new Genre(name);
        this.entityManager.persist(genre);
        return genre;
    }
}
