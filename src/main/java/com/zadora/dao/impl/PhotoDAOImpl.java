package com.zadora.dao.impl;

import com.zadora.dao.PhotoDAO;
import com.zadora.dto.Photo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by adam on 06.02.2017.
 */
@Repository
@Transactional
public class PhotoDAOImpl implements PhotoDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Long add(Photo photo) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(photo);
        return photo.getId();
    }

    @Override
    public Long update(Photo photo) {
        Session session = sessionFactory.getCurrentSession();
        session.update(photo);
        return photo.getId();
    }

    @Override
    public List<Photo> list() {
        Session session= sessionFactory.getCurrentSession();
        return session.createQuery("from Photo").list();
    }

    @Override
    public Photo getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Photo.class, id);
    }

    @Override
    public void remove(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getById(id));
    }
}
