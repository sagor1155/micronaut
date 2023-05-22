package com.example;

import com.example.domain.Genre;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

@Controller("/genres")
public class GenreController {

    private final GenreRepository genreRepository;

    public GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Get("/{id}")
    public Genre getGenre(Long id) {
        return this.genreRepository
                .findById(id)
                .orElse(null);
    }

    @Post(value = "/create", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public HttpResponse<Genre> createGenre(final Genre genre) {
        Genre genreCreated = this.genreRepository.save(genre.getName());
        System.out.println("Genre created: " + genreCreated.toString());
        return HttpResponse.created(genreCreated);
    }
}
