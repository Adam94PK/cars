package com.zadora.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by adam on 06.01.17.
 */

@Entity
public class Photo {

    private Long id;
    private String url;
    private String name;
    private String description;
    @JsonIgnore
    private Car car;
    private Long carID;

    public Photo() {
    }

    public Photo(String url) {
        this.url = url;
    }

    public Photo(Car car, String url, String name) {
        this.car = car;
        this.url = url;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @ManyToOne
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
        this.carID = car.getId();
    }

    @Transient
    public Long getCarID() {
        return carID;
    }
    public void setCarID(Long carID) {
        this.carID = carID;
    }

}
