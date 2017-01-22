package com.zadora.dao;

import com.zadora.dto.Car;
import com.zadora.dto.Purchase;

import java.util.List;

/**
 * Created by adam on 20.01.2017.
 */
public interface PurchaseDAO {
    void add(Purchase purchase);
    void update(Purchase purchase);
    List<Purchase> list();
    Purchase getById(Long id);
    void remove(Long id);
}
