package com.zadora.dao.impl;

import com.zadora.dao.UserDAO;
import com.zadora.dto.User;
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
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Boolean add(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
        return true;
    }

    @Override
    public Boolean update(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
        return true;
    }

    @Override
    public List<User> list() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User").list();
    }

    @Override
    public User getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public Boolean remove(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getById(id));
        return true;
    }
}
