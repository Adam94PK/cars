package com.zadora.dao;

import com.zadora.dto.User;

import java.util.List;

/**
 * Created by adam on 07.01.17.
 */
public interface UserDAO {

    Boolean add(User user);
    Boolean update(User user);
    List<User> list();
    User getById(Long id);
    Boolean remove(Long id);

}
