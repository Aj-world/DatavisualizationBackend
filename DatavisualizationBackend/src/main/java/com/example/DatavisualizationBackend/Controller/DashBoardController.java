package com.example.DatavisualizationBackend.Controller;


import com.example.DatavisualizationBackend.Services.DataEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = "*")
public class DashBoardController {

    private final DataEntityService dataServices;

    @Autowired
    public DashBoardController(DataEntityService dataServices) {
        this.dataServices = dataServices;
    }





    @GetMapping("/values/{columnName}")
    public ResponseEntity<?> getAllValuesByColumn(@PathVariable String columnName) {
        try {
             var objects =  dataServices.findAllValuesByColumn(columnName);

            return ResponseEntity.ok(objects);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while fetching user data: " + e.getMessage());
        }
    }




    @GetMapping("/data/by-topic/{topic}")
    public ResponseEntity<?> getByTopic(@PathVariable String topic) {
        try {
             var objects =  dataServices.getAllByTopic(topic);

            return ResponseEntity.ok(objects);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while fetching user data: " + e.getMessage());
        }
    }

    @GetMapping("/data/by-year/{year}")
    public ResponseEntity<?> getByYear(@PathVariable int year) {
        try {
             var objects =  dataServices.getAllByYear(year);

            return ResponseEntity.ok(objects);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while fetching user data: " + e.getMessage());
        }
    }


    @GetMapping("/data/by-country/{country}")
    public ResponseEntity<?> getByCountry(@PathVariable String country) {
        try {
             var objects = dataServices.getAllByCountry(country);

            return ResponseEntity.ok(objects);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while fetching user data: " + e.getMessage());
        }
    }

    @GetMapping("/data/by-region/{region}")
    public ResponseEntity<?>  getByRegion(@PathVariable String region) {
        try {
             var objects =  dataServices.getAllByRegion(region);

            return ResponseEntity.ok(objects);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while fetching user data: " + e.getMessage());
        }
    }

    @GetMapping("/data/by-city/{city}")
    public ResponseEntity<?> getByCity(@PathVariable String city) {
        try {
             var objects =   dataServices.getAllByCity(city);

            return ResponseEntity.ok(objects);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while fetching user data: " + e.getMessage());
        }
    }


    @GetMapping("/data/by-intensity/{intensity}")
    public ResponseEntity<?> getByIntensity(@PathVariable Integer intensity) {
        try {
             var objects =  dataServices.getAllByIntensity(intensity);

            return ResponseEntity.ok(objects);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while fetching user data: " + e.getMessage());
        }
    }


    @GetMapping("/data/by-likelihood/{likelihood}")
    public ResponseEntity<?> getByLikelihood(@PathVariable Integer likelihood) {
        try {
             var objects = dataServices.getAllByLikelihood(likelihood);

            return ResponseEntity.ok(objects);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while fetching user data: " + e.getMessage());
        }
    }

    @GetMapping("/data/by-relevance/{relevance}")
    public ResponseEntity<?> getByRelevance(@PathVariable Integer relevance) {
        try {
             var objects = dataServices.getAllByRelevance(relevance);

            return ResponseEntity.ok(objects);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while fetching user data: " + e.getMessage());
        }
    }



}
