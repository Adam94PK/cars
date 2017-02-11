package com.zadora.services;

import com.zadora.dao.CarDAO;
import com.zadora.dao.PhotoDAO;
import com.zadora.dto.Car;
import com.zadora.dto.Photo;
import com.zadora.file.FileSaver;
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
    @Autowired
    private PhotoDAO photoDAO;

    @CrossOrigin
    @PostMapping("/car/add")
    public Car saveCar(@RequestBody Car car){
        carDAO.add(car);
        return car;
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/car/pictures/add")
    public void saveCar(@RequestBody List<MultipartFile> files, @RequestParam String car) throws IOException {
        System.out.println(car);
        for(MultipartFile file : files){
            File filePath = new File(".\\build\\resources\\main\\static\\" + car);
            System.out.println(filePath.mkdirs());
            FileSaver.saveFile(file, filePath);
            photoDAO.add(new Photo(carDAO.getById(Long.parseLong(car)), car + "/" + file.getOriginalFilename(), file.getOriginalFilename()));
        }
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
