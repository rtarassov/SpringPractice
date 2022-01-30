package com.sda.javaee9spring.controller;

import com.sda.javaee9spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MovieController {
//    @Autowired // field injection is allowed only in tests!!!! Use always constructors!!!
//    private MovieService movieService;

    private MovieService movieService;
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
}