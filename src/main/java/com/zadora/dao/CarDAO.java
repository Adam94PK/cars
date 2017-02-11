package com.zadora.dao;

import com.zadora.dto.Car;

import java.util.List;

/**
 * Created by adam on 07.01.17.
 */
public interface CarDAO {

    Long add(Car car);
    Long update(Car car);
    List<Car> list();
    Car getById(Long id);
    void remove(Long id);
}
