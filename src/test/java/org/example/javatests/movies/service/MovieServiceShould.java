package org.example.javatests.movies.service;

import org.example.javatests.movies.data.MovieRepository;
import org.example.javatests.movies.model.Genre;
import org.example.javatests.movies.model.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceShould {
    private MovieService movieService;
    @BeforeEach
    void setUp() {
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1,"Dark Knight", 152, Genre.ACTION),
                        new Movie(2,"Memento", 113, Genre.THRILLER),
                        new Movie(3,"There's Something About Mary", 119, Genre.COMEDY),
                        new Movie(4,"Super 8", 112, Genre.THRILLER),
                        new Movie(5,"Scream", 111, Genre.HORROR),
                        new Movie(6,"Home Alone", 103, Genre.COMEDY),
                        new Movie(7,"Matrix", 136, Genre.ACTION)
                )
        );
        movieService = new MovieService(movieRepository);
    }

    @Test
    void returnMoviesByGenre() {
        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);
        Assertions.assertEquals(Arrays.asList(3,6), getMovieIds(movies));
    }

    @Test
    void returnMoviesByDuration() {
        Collection<Movie> movies = movieService.findMoviesByLength(119);
        Assertions.assertEquals(Arrays.asList(2,3,4,5,6), getMovieIds(movies));
    }

    private static List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }
}