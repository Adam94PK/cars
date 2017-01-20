package com.zadora.example;

import com.zadora.dao.CarDAO;
import com.zadora.dao.TestRideDAO;
import com.zadora.dao.UserDAO;
import com.zadora.dto.Car;
import com.zadora.dto.TestRide;
import com.zadora.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by adam on 05.01.17.
 */

@RestController
public class TestClass {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private TestRideDAO testRideDAO;
    @Autowired
    private CarDAO carDAO;

    @RequestMapping("/")
    public List<User> home(@RequestParam(value="name", defaultValue = "Adam") String name, @RequestParam(value = "surname", defaultValue = "Zadora") String surname){
        userDAO.add(new User("Adam", "Zadora"));
        userDAO.add(new User("Klaudia", "Hajto"));
        Car car = new Car();
        car.setMake("BMW");
        car.setModel("X5");
        car.setPrice(500);
        carDAO.add(car);
        TestRide testRide = new TestRide();
        testRide.setUser(userDAO.getById(1L));
        testRide.setCreateDate(new Date());
        testRide.setCar(car);
        testRideDAO.add(testRide);
        return userDAO.list();
    }

    @RequestMapping("/test_rides")
    public List<TestRide> getTestRides(){
        return testRideDAO.list();
    }

    @RequestMapping("/cars")
    public List<Car> getCars(){
        return carDAO.list();
    }
}