package com.example.catalogservice.service;

import com.example.catalogservice.model.Movie;

import java.util.List;
public interface MovieService {
    List<Movie> findByGenre();

}