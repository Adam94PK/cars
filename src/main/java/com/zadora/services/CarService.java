package com.zadora.services;

import com.zadora.dao.CarDAO;
import com.zadora.dto.Car;
import com.zadora.file.FileSaver;
import com.zadora.file.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by adam on 20.01.2017.
 */
@RestController
public class CarService {

    @Autowired
    private CarDAO carDAO;

//    @CrossOrigin
//    @PostMapping("/save-cars")
//    public Car saveCar(@RequestParam(value="vin")String vin, @RequestParam(value="make")String make
//            , @RequestParam(value="model")String model, @RequestParam(value="year")Integer year
//            , @RequestParam(value="price")Float price, @RequestParam(value="visible", defaultValue = "true")Boolean visible){
//        Car car = new Car(vin, make, model, year, price, visible);
//        carDAO.add(car);
//        return car;
//    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/save-car")
    public void saveCar(@RequestBody List<MultipartFile> files) throws IOException {
        System.out.println(files);
        for(MultipartFile file : files){
            File filePath = new File(".\\photos");
            FileSaver.saveFile(file, filePath);
        }
        System.out.println("FILE ========== \n");
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
