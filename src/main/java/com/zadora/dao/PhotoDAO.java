package com.zadora.dao;

import com.zadora.dto.Photo;

import java.util.List;

/**
 * Created by adam on 06.02.2017.
 */
public interface PhotoDAO {
    Long add(Photo photo);
    Long update(Photo photo);
    List<Photo> list();
    Photo getById(Long id);
    void remove(Long id);
}
