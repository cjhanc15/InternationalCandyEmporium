package com.gcu.internationalcandyemporium.Interfaces;
import java.util.List;

import com.gcu.internationalcandyemporium.Data.Entities.UserEntity;

public interface DataAccessInterface<T> {
    List<UserEntity> findAll();
    T findById(int id);
    boolean create(T t);
    boolean update(T t);
    boolean delete(T t);
}

