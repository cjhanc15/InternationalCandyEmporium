package com.gcu.internationalcandyemporium.Interfaces;
import java.util.List;

public interface DataAccessInterface<T> {
    List<T> findAll();
    T findById(int id);
    boolean create(T t);
    boolean update(T t);
    boolean delete(T t);
}

