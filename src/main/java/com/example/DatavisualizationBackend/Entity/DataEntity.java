package com.example.DatavisualizationBackend.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "data")
public class DataEntity {

    @Id
    private Long id;

    @Column(name = "intensity")
    private Integer intensity;

    @Column(name = "likelihood")
    private Integer likelihood;

    @Column(name = "relevance")
    private Integer relevance;

    @Column(name = "year")
    private int year;

    @Column(name = "country")
    private String country;

    @Column(name = "topic")
    private String topic;

    @Column(name = "region")
    private String region;

    @Column(name = "city")
    private String city;



}
