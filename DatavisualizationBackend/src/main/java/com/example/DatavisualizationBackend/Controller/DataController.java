package com.example.DatavisualizationBackend.Controller;

import com.example.DatavisualizationBackend.Entity.DataEntity;
import com.example.DatavisualizationBackend.Services.DataServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
public class DataController {

    private final DataServices dataServices;

    @Autowired
    public DataController(DataServices dataServices) {
        this.dataServices = dataServices;
    }


    @GetMapping("/getAllData")
    public ResponseEntity<?> getAllData() {
        try {
            List<DataEntity> objects = dataServices.findAllData();

            return ResponseEntity.ok(objects);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while fetching user data: " + e.getMessage());
        }
    }


    @GetMapping("/getAllYear")
    public ResponseEntity<?> getAllYear() {
        try {
            List<Integer> objects = dataServices.findAllYearData();

            return ResponseEntity.ok(objects);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while fetching user data: " + e.getMessage());
        }
    }


    @GetMapping("/getAllRegion")
    public ResponseEntity<?> getAllRegion() {
        try {
            List<String> objects = dataServices.findAllRegionData();

            return ResponseEntity.ok(objects);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while fetching user data: " + e.getMessage());
        }
    }

    @GetMapping("/findAllByYear/{year}")
    public ResponseEntity<?> findAllByYear(@PathVariable int year) {
        try {
            List<DataEntity> data = dataServices.findAllDataByYear(year);
            Set<String> resultSet = data.stream()
                    .map(DataEntity::getRegion) // Mapping the region property directly
                    .collect(Collectors.toSet());

            return ResponseEntity.ok(resultSet);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while fetching data: " + e.getMessage());
        }
    }


    @GetMapping("/your-url/{param1}/{param2}")
    public ResponseEntity<?> fetchData(@PathVariable Integer  param1, @PathVariable String param2) {
        try {

            List<DataEntity> objects =dataServices.findAllRegionAndYearData(param1,param2) ;

            return ResponseEntity.ok(objects);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while fetching user data: " + e.getMessage());
        }
    }



}
