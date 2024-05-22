package com.example.DatavisualizationBackend.Reposetry;

import com.example.DatavisualizationBackend.Entity.DataEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface DataReposetry extends CrudRepository<DataEntity,Integer> {


    Iterable<DataEntity> findAll();

    List<DataEntity> findByYearAndRegion( Integer year,String region);


    @Query(value = "SELECT year FROM Datavisualization.data", nativeQuery = true)
    Set<Integer> findAllYear();

    @Query(value = "SELECT region FROM Datavisualization.data", nativeQuery = true)
    Set<String> findAllRegion();



    // Find all by name
    List<DataEntity> findAllByTopic(String topic);

    // Find all by year
    List<DataEntity> findAllByYear(int year);

    // Find all by country
    List<DataEntity> findAllByCountry(String country);

    // Find all by region
    List<DataEntity> findAllByRegion(String region);

    // Find all by city
    List<DataEntity> findAllByCity(String city);

    // Find all by intensity
    List<DataEntity> findAllByIntensity(Integer intensity);

    // Find all by likelihood
    List<DataEntity> findAllByLikelihood(Integer likelihood);

    // Find all by relevance
    List<DataEntity> findAllByRelevance(Integer relevance);

}
