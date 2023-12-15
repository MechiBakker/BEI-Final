package com.dh.catalogservice.client;


import com.dh.catalogservice.model.Serie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "serie-service")
public interface ISerieClient {

    @GetMapping("/api/v1/series/{genre}")
    ResponseEntity<List<Serie>> getSeriesBygGenre(@PathVariable String genre);
}