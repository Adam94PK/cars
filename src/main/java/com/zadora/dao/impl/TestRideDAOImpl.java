package com.zadora.dao.impl;

import com.zadora.dao.TestRideDAO;
import com.zadora.dto.TestRide;
import com.zadora.dto.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by adam on 07.01.17.
 */
@Repository
@Transactional
public class TestRideDAOImpl implements TestRideDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long add(TestRide testRide) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(testRide);
        return testRide.getId();
    }

    @Override
    public Long update(TestRide testRide) {
        Session session = sessionFactory.getCurrentSession();
        session.update(testRide);
        return testRide.getId();
    }

    @Override
    public List<TestRide> list() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from TestRide").list();
    }

    @Override
    public TestRide getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(TestRide.class, id);
    }

    @Override
    public void remove(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getById(id));
    }

    @Override
    public List<TestRide> getTestRidesByUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        //TODO
        return null;
    }
}
