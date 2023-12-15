package com.dh.catalogservice.repository;

<<<<<<< HEAD
import org.springframework.data.mongodb.repository.MongoRepository;
import com.dh.catalogservice.model.Movie;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, Long> {
=======
import com.dh.catalogservice.model.Movie;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
@FeignClient(name = "movie-service")
public interface MovieRepository extends JpaRepository<Movie, Long>{
    List<Movie> findMovieByGenre(String genre);
>>>>>>> 43ffeeccfda0cc06571a9f76550acb289657f3c8
}
