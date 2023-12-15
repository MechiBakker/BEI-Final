package com.dh.catalogservice.repository;

<<<<<<< HEAD
import org.springframework.data.mongodb.repository.MongoRepository;
import com.dh.catalogservice.model.Serie;
import org.springframework.stereotype.Repository;

@Repository
public interface SerieRepository extends MongoRepository<Serie, Long> {
=======
import com.dh.catalogservice.model.Serie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@FeignClient(name = "serie-service")
public interface SerieRepository extends MongoRepository<Serie, Long> {
    List<Serie> findSerieByGenre(String genre);
>>>>>>> 43ffeeccfda0cc06571a9f76550acb289657f3c8
}
