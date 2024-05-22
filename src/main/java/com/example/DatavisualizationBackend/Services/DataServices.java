package com.example.DatavisualizationBackend.Services;


import com.example.DatavisualizationBackend.Entity.DataEntity;
import com.example.DatavisualizationBackend.Reposetry.DataReposetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DataServices {
    private final DataReposetry dataReposetry;

    @Autowired
    public DataServices(DataReposetry dataReposetry) {
        this.dataReposetry = dataReposetry;
    }

    public List<DataEntity> findAllData() {
        Iterable<DataEntity> iterable = dataReposetry.findAll();
        List<DataEntity> dataList = new ArrayList<>();
        iterable.forEach(dataList::add);
        return dataList;
    }
    public List<Integer> findAllYearData() {

        Set<Integer> objects= dataReposetry.findAllYear();

        List<Integer> sortedList = new ArrayList<>(objects);

        Collections.sort(sortedList);
        return sortedList;
    }

    public List<String> findAllRegionData() {

        Set<String> objects= dataReposetry.findAllRegion();

        List<String> sortedList = new ArrayList<>(objects);

        Collections.sort(sortedList);
        return sortedList;
    }

    public List<DataEntity> findAllRegionAndYearData(int year,String region) {

        return dataReposetry.findByYearAndRegion(year,region);


    }
        public List<DataEntity> findAllDataByYear(int year) {

        return dataReposetry.findAllByYear(year) ;
    }


}


