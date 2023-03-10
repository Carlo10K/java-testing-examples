package org.example.javatests.movies.service;

import org.example.javatests.movies.data.MovieRepository;
import org.example.javatests.movies.model.Genre;
import org.example.javatests.movies.model.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
                        new Movie(1,"Dark Knight", 152, "Christopher Nolan", Genre.ACTION),
                        new Movie(2,"Memento", 113, "Christopher Nolan",Genre.THRILLER),
                        new Movie(3,"There's Something About Mary", 119, "Peter Farrelly", Genre.COMEDY),
                        new Movie(4,"Super 8", 112, "J. J. Abrams", Genre.THRILLER),
                        new Movie(5,"Scream", 111, "Tyler Gillett", Genre.HORROR),
                        new Movie(6,"Home Alone", 103, "Chris Columbus", Genre.COMEDY),
                        new Movie(7,"Matrix", 136, "Wachowski Sisters", Genre.ACTION),
                        new Movie(8,"Superman", 110, "Zack Snyder", Genre.ACTION)
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
        Assertions.assertEquals(Arrays.asList(2,3,4,5,6,8), getMovieIds(movies));
    }

    @Test
    void returnMoviesByName() {
        Collection<Movie> movies = movieService.findMoviesByName("Super");
        Assertions.assertEquals(Arrays.asList(4,8), getMovieIds(movies));
    }

    @Test
    void returnMoviesByDirector() {
        Collection<Movie> movies = movieService.findMoviesByDirector("nolan");
        Assertions.assertEquals(Arrays.asList(1,2), getMovieIds(movies));
    }


    @Nested
    class returnMoviesByTemplate {

        @Test
        void whenUsingId() {
            Collection<Movie> movies = movieService.findMoviesByTemplate( new Movie(1,null, 0, null, null));
            Assertions.assertEquals(Collections.singletonList(1), getMovieIds(movies));
        }

        @Test
        void whenUsingDirectorAndMinutes() {
            Collection<Movie> movies = movieService.findMoviesByTemplate( new Movie(null,null, 160, "Nolan", null));
            Assertions.assertEquals(Arrays.asList(1,2), getMovieIds(movies));
        }

        @Test
        void whenUsingNameAndMinutes() {
            Collection<Movie> movies = movieService.findMoviesByTemplate( new Movie(null,"super", 160, null, null));
            Assertions.assertEquals(Arrays.asList(4,8), getMovieIds(movies));
        }

        @Test
        void whenUsingGenreAndMinutes() {
            Collection<Movie> movies = movieService.findMoviesByTemplate( new Movie(null,null, 113, null, Genre.THRILLER));
            Assertions.assertEquals(Arrays.asList(2,4), getMovieIds(movies));
        }

        @Test
        void whenUsingNegativeMinutes() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                movieService.findMoviesByTemplate( new Movie(null,null, -1, null, null));
            });
            String expectedMessage = "the duration is not valid";
            String actualMessage = exception.getMessage();

            Assertions.assertTrue(actualMessage.contains(expectedMessage));
        }
    }

    private static List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }
}