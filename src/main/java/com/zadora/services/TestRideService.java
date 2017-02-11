package com.zadora.services;

import com.zadora.dao.CarDAO;
import com.zadora.dao.TestRideDAO;
import com.zadora.dao.UserDAO;
import com.zadora.dto.TestRide;
import com.zadora.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adam on 07.02.2017.
 */

@RestController
public class TestRideService {

    @Autowired
    CarDAO carDAO;
    @Autowired
    TestRideDAO testRideDAO;
    @Autowired
    UserDAO user;

    @CrossOrigin
    @PostMapping("/test-ride/add")
    public TestRide addTestRide(@RequestParam User user, @RequestParam TestRide testRide){
        testRide.setUser(user);
        testRideDAO.add(testRide);
        return testRideDAO.getById(testRide.getId());
    }

    @CrossOrigin
    @PostMapping("/test-ride/update")
    public TestRide updateTestRide(@RequestParam User user, @RequestParam TestRide testRide){
        if(testRide.getUser().equals(user)){
            testRideDAO.update(testRide);
            return testRideDAO.getById(testRide.getId());
        }
        return null;
    }

    @CrossOrigin
    @GetMapping("/test-ride/get")
    public TestRide getTestRide(@RequestParam Long testRideId){
        return testRideDAO.getById(testRideId);
    }

    @CrossOrigin
    @GetMapping("/test-ride/get-all")
    public List<TestRide> getAllTestRides(@RequestParam User user){
        if(user.getAdmin()){
            return testRideDAO.list();
        }
        return new ArrayList<>();
    }

}
