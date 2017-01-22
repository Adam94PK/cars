package com.zadora.services;

import com.zadora.dao.CarDAO;
import com.zadora.dto.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by adam on 20.01.2017.
 */
@RestController(value = "car-serivce")
public class CarService {

    @Autowired
    private CarDAO carDAO;

    @RequestMapping("/add-car")
    public Car addCar(@RequestParam(value="vin")String vin, @RequestParam(value="make")String make
            , @RequestParam(value="model")String model, @RequestParam(value="year")Integer year
            , @RequestParam(value="price")Float price, @RequestParam(value="visible", defaultValue = "true")Boolean visible){
        Car car = new Car(vin, make, model, year, price, visible);
        carDAO.add(car);
        return car;
    }

    @RequestMapping("/car/remove")
    public void removeCar(@RequestParam(value = "carID")Long carID){
        carDAO.remove(carID);
    }

    @CrossOrigin
    @GetMapping("/get-cars")
    public List<Car> getCars(){
        return carDAO.list();
    }

}
