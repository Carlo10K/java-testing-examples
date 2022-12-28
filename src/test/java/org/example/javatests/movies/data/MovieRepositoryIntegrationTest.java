package org.example.javatests.movies.data;

import org.example.javatests.movies.model.Genre;
import org.example.javatests.movies.model.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryIntegrationTest {


    private MovieRepositoryJdbc movieRepository;

    @BeforeEach
    void setUp() throws SQLException {
        DataSource dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/data.sql"));
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        movieRepository = new MovieRepositoryJdbc(jdbcTemplate);
    }

    @Test
    void loadMovies(){
        Collection<Movie> movies = movieRepository.findAll();
        Assertions.assertEquals(Arrays.asList(
                new Movie(1,"Dark Knight", 152, "Christopher Nolan", Genre.ACTION),
                new Movie(2,"Memento", 113, "Christopher Nolan", Genre.THRILLER),
                new Movie(3,"Matrix", 136, "Wachowski Sisters", Genre.ACTION)
        ), movies);
    }

    @Test
    void loadById() {
        Movie movie = movieRepository.findById(2);
        Assertions.assertEquals(new Movie(2,"Memento",113, "Christopher Nolan", Genre.THRILLER), movie);
    }

    @Test
    void insertMovie() {
        Movie movie = new Movie("Super ", 112, "Christopher Nolan", Genre.THRILLER);
        movieRepository.saveOrUpdate(movie);

        Movie movieFromDB = movieRepository.findById(4);
        Assertions.assertEquals(new Movie(4,"Super ", 112, "Christopher Nolan", Genre.THRILLER), movieFromDB  );
    }
}