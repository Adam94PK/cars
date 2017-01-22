package com.zadora.dao.impl;

import com.zadora.dao.CarDAO;
import com.zadora.dto.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by adam on 07.01.17.
 */

@Repository
@Transactional
public class CarDAOImpl implements CarDAO {

    private static final Logger log = LoggerFactory.getLogger(CarDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public CarDAOImpl() {
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Car car) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(car);
    }

    @Override
    public void update(Car car) {
        Session session = sessionFactory.getCurrentSession();
        session.update(car);
    }

    @Override
    public List<Car> list() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Car").list();
    }

    @Override
    public Car getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Car.class, id);
    }

    @Override
    public void remove(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getById(id));
    }
}
