package com.zadora.dao.impl;

import com.zadora.dao.PurchaseDAO;
import com.zadora.dto.Car;
import com.zadora.dto.Purchase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by adam on 20.01.2017.
 */

@Repository
@Transactional
public class PurchaseDAOImpl implements PurchaseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Purchase purchase) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(purchase);
    }

    @Override
    public void update(Purchase purchase) {
        Session session = sessionFactory.getCurrentSession();
        session.update(purchase);
    }

    @Override
    public List<Purchase> list() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Purchase").list();
    }

    @Override
    public Purchase getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Purchase.class, id);
    }

    @Override
    public void remove(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getById(id));
    }
}
