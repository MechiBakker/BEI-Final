package com.example.catalogervice.service.impl;

import com.example.catalogservice.model.movie;
import com.example.catalogservice.repository.MovieRepository; /*ver si uso client*/
import com.example.courseservice.service.StudentService;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    private CircuitBreakerRegistry circuitBreakerRegistry;

    @CircuitBreaker(name = "movies", fallbackMethod = "findAllEmptyFallback")
    @Retry(name = "movies")
    @Override
    public List<Movie> findByGenre() {
        log.info("Calling movie service ...");
        return movieRepository.getMovieBygGenre();
    }
    private List<Movie> findAllEmptyFallback(CallNotPermittedException exception) {
        return "Error en la petición";
    }
}
