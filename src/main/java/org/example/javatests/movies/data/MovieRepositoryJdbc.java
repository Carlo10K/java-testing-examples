package org.example.javatests.movies.data;

import org.example.javatests.movies.model.Genre;
import org.example.javatests.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.util.Collection;
import java.util.Objects;

public class MovieRepositoryJdbc implements MovieRepository {
    private final JdbcTemplate jdbcTemplate;

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        Object[] args ={ id };
        return jdbcTemplate.queryForObject("SELECT * FROM movies WHERE id = ?",args, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {
        return jdbcTemplate.query("SELECT * FROM movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        jdbcTemplate.update("INSERT INTO movies (name, minutes, director, genre) values (?,?,?,?)",
                movie.getName(),
                movie.getMinutes(),
                movie.getDirector(),
                movie.getGenre().toString()
                );
    }

    RowMapper<Movie> movieMapper = (rs, rowNum) -> new Movie(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getInt("minutes"),
            rs.getString("director"),
            Genre.valueOf(rs.getString("genre")));
}
