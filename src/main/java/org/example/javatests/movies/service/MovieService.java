package org.example.javatests.movies.service;

import org.example.javatests.movies.data.MovieRepository;
import org.example.javatests.movies.model.Genre;
import org.example.javatests.movies.model.Movie;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//negocio
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }
    public Collection<Movie> findMoviesByGenre(Genre genre) {

        return movieRepository.findAll().stream().filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByLength(int length) {
        return movieRepository.findAll().stream().filter(movie -> movie.getMinutes() <= length).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByName(String name){
        return movieRepository.findAll().stream().filter(movie -> movie.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByDirector(String name){
        return movieRepository.findAll().stream().filter(movie -> movie.getDirector().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByTemplate(Movie template){
        List<Predicate<Movie>> collector;

        if (template.getId()!=null){
            return movieRepository.findAll().stream().filter(movie -> movie.getId().equals(template.getId())).collect(Collectors.toList());
        }else if (template.getMinutes() <= 0){
            throw new IllegalArgumentException("the duration is not valid");
        }else{
            List<String> filter = new ArrayList<>();
            if (template.getName() != null && !Objects.equals(template.getName().trim(), "")){
                filter.add(template.getName());
            }

            if(template.getMinutes()>0){
                filter.add(String.valueOf(template.getMinutes()));
            }

            if(template.getDirector()!= null && !template.getDirector().trim().equals("")){
                filter.add(template.getDirector());
            }

            if (template.getGenre()!=null && !template.getGenre().toString().equals("")){
                filter.add(template.getGenre().toString());
            }

            collector = getPredicates(template, filter);

            return movieRepository.findAll().stream().filter(collector.stream().reduce(x -> false, Predicate::or)).collect(Collectors.toList());
        }
    }

    private static List<Predicate<Movie>> getPredicates(Movie template, List<String> filter) {
        List<Predicate<Movie>> collector;
        collector = new ArrayList<Predicate<Movie>>();
        for(String f : filter){
            if (template.getMinutes()>0 && template.getDirector()!=null){
                collector.add(a -> a.getMinutes() < template.getMinutes() && a.getDirector().toLowerCase().contains(f.toLowerCase()));
            }

            if(template.getName()!=null && template.getMinutes()>0){
                collector.add(a -> a.getName().toLowerCase().contains(f.toLowerCase()) && a.getMinutes() < template.getMinutes());
            }

            if(template.getGenre()!=null && template.getMinutes()>0){
                collector.add(a -> a.getGenre().toString().toLowerCase().contains(f.toLowerCase()) && a.getMinutes() <= template.getMinutes());
            }
        }
        return collector;
    }
}
