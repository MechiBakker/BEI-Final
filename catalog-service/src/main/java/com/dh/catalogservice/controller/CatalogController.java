package com.dh.catalogservice.controller;

import com.dh.catalogservice.client.IMovieClient;
import com.dh.catalogservice.client.ISerieClient;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.cloud.context.config.annotation.RefreshScope;


import java.util.List;

@RefreshScope
@RestController
@RequiredArgsConstructor

public class CatalogController {

    @Autowired
    private IMovieClient iMovieClient;

    @Autowired
    private ISerieClient iSerieClient;

    private final CatalogListener listener;
    private final MovieSender movieSender;
    private final SerieSender serieSender;

    @GetMapping("/{name}")
    public ResponseEntity<List<Catalog>> getCatalogByName(@PathVariable String name) {
        return ResponseEntity.ok().body(service.findCaralogByName(name));
    }

    @PostMapping("/saveSerie")
    public ResponseEntity<?> saveSerie(@RequestBody Serie serie) {
        sender.send(serie);
        return ResponseEntity.noContent().build();}

    @PostMapping("/saveMovie")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie) {
        sender.send(movie);
        return ResponseEntity.noContent().build();
    }

   /*
    @GetMapping("/api/v1/movies/{genre}")
    ResponseEntity<List<Movie>> findByGenre(@PathVariable String genre) {
        return iMovieClient.getMovieByGenre(genre);
    }
    @GetMapping("/api/v1/series/{genre}")
    ResponseEntity<List<Serie>> getSerieByGenre(@PathVariable String genre) {
        return iSerieClient.getSeriesBygGenre(genre);
    }*/

}
