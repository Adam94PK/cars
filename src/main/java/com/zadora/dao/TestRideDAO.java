package com.zadora.dao;

import com.zadora.dto.TestRide;

import java.util.List;

/**
 * Created by adam on 07.01.17.
 */
public interface TestRideDAO {

    Boolean add(TestRide testRide);
    Boolean update(TestRide testRide);
    List<TestRide> list();
    TestRide getById(Long id);
    Boolean remove(Long id);
}
