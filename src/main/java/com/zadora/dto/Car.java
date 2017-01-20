package com.zadora.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;

/**
 * Created by adam on 06.01.17.
 */

@Entity
public class Car {


    private Long id;
    private String vin;
    private String make;
    private String model;
    private Integer year;
    private Integer price;
    private Boolean visible;
    private List<Photo> photos;
    private List<TestRide> testRides;
    @Transient
    private List<Long> photosIds;
    @Transient
    private List<Long> testRidesIds;

    public Car() {
    }

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }
    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getVisible() {
        return visible;
    }
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
    @JsonIgnore
    @OneToMany(mappedBy = "car")
    public List<Photo> getPhotos() {
        return photos;
    }
    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
    @JsonIgnore
    @OneToMany(mappedBy = "car")
    public List<TestRide> getTestRides() {
        return testRides;
    }
    public void setTestRides(List<TestRide> testRides) {
        this.testRides = testRides;
        for(TestRide testRide : testRides){
            testRidesIds.add(testRide.getId());
        }
    }

    public List<Long> getPhotosIds() {
        return photosIds;
    }
    public void setPhotosIds(List<Long> photosIds) {
        this.photosIds = photosIds;
    }

    public List<Long> getTestRidesIds() {
        return testRidesIds;
    }
    public void setTestRidesIds(List<Long> testRidesIds) {
        this.testRidesIds = testRidesIds;
    }
}
