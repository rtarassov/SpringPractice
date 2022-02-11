package com.sda.javaee9spring.repository;

import com.sda.javaee9spring.entity.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository {

    public List<Movie> readAllMoviesFromDatabase() {
        return List.of();
    }
}