package com.example.catalogservice.service;

import com.example.catalogservice.model.Serie;

import java.util.List;
public interface SerieService {
    List<Serie> getSeriesBygGenre();

}