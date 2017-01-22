package com.zadora.dao;

import com.zadora.dto.User;

import java.util.List;

/**
 * Created by adam on 07.01.17.
 */
public interface UserDAO {

    void add(User user);
    void update(User user);
    List<User> list();
    User getById(Long id);
    void remove(Long id);

}
