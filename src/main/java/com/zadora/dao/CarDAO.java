package com.zadora.dao;

import com.zadora.dto.Car;

import java.util.List;

/**
 * Created by adam on 07.01.17.
 */
public interface CarDAO {

    Boolean add(Car car);
    Boolean update(Car car);
    List<Car> list();
    Car getById(Long id);
    Boolean remove(Long id);
}
