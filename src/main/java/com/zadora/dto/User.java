package com.zadora.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by adam on 05.01.17.
 */


@Entity
public class User {

    private Long resID;
    private Boolean admin;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private List<TestRide> testRides;
    private List<Long> testRidesIds;

    public User() {
    }

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getResID() {
        return resID;
    }
    public void setResID(Long resID) {
        this.resID = resID;
    }

    public Boolean getAdmin() {
        return admin;
    }
    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    public List<TestRide> getTestRides() {
        return testRides;
    }
    public void setTestRides(List<TestRide> testRides) {
        this.testRides = testRides;
        for(TestRide testRide : testRides){
            testRidesIds.add(testRide.getId());
        }
    }
    @Transient
    public List<Long> getTestRidesIds() {
        return testRidesIds;
    }
    public void setTestRidesIds(List<Long> testRidesIds) {
        this.testRidesIds = testRidesIds;
    }
}
