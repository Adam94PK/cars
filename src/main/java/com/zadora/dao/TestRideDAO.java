package com.zadora.dao;

import com.zadora.dto.TestRide;
import com.zadora.dto.User;
import org.aspectj.weaver.ast.Test;

import java.util.List;

/**
 * Created by adam on 07.01.17.
 */
public interface TestRideDAO {

    Long add(TestRide testRide);

    Long update(TestRide testRide);

    List<TestRide> list();

    TestRide getById(Long id);

    void remove(Long id);

    List<TestRide> getTestRidesByUser(User user);
}
