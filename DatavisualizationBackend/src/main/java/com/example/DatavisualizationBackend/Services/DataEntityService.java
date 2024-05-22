package com.example.DatavisualizationBackend.Services;

import com.example.DatavisualizationBackend.Entity.DataEntity;
import com.example.DatavisualizationBackend.Reposetry.DataReposetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DataEntityService {

    private final DataReposetry dataReposetry;

    @Autowired
    public DataEntityService(DataReposetry dataReposetry) {
        this.dataReposetry = dataReposetry;
    }


    public List<DataEntity> getAllByTopic(String topic) {
        return dataReposetry.findAllByTopic(topic);
    }

    public List<DataEntity> getAllByYear(int year) {
        return dataReposetry.findAllByYear(year);
    }

    public List<DataEntity> getAllByCountry(String country) {
        return dataReposetry.findAllByCountry(country);
    }

    public List<DataEntity> getAllByRegion(String region) {
        return dataReposetry.findAllByRegion(region);
    }

    public List<DataEntity> getAllByCity(String city) {
        return dataReposetry.findAllByCity(city);
    }

    public List<DataEntity> getAllByIntensity(Integer intensity) {
        return dataReposetry.findAllByIntensity(intensity);
    }

    public List<DataEntity> getAllByLikelihood(Integer likelihood) {
        return dataReposetry.findAllByLikelihood(likelihood);
    }

    public List<DataEntity> getAllByRelevance(Integer relevance) {
        return dataReposetry.findAllByRelevance(relevance);
    }


    public Set<?> findAllValuesByColumn(String columnName) {
        Iterable<DataEntity> iterable = dataReposetry.findAll();
        Set<DataEntity> dataSet = StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toSet());

         return dataSet.stream()
                .map(dataEntity -> {
                    try {
                        Method method = DataEntity.class.getMethod("get" + columnName.substring(0, 1).toUpperCase() + columnName.substring(1));
                        return method.invoke(dataEntity);
                    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .collect(Collectors.toSet());
    }

}
