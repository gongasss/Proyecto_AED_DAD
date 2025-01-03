package org.example.proyecto_aed_dad.dao.interfaces;

import java.util.List;

public interface GenericDao<T> {
    void insert(T entity);
    T getById(int id);
    void update(T entity);
    void delete(T entity);
    List<T> findAll();
}
