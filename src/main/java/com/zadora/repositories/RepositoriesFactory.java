package com.zadora.repositories;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by adam on 07.01.17.
 */
public class RepositoriesFactory {

    @Autowired
    private UserRepository repository;

    public UserRepository getUserRepository(){
        return repository;
    }
}
