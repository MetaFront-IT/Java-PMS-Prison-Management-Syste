package com.Arshan.models.dao;

import java.util.List;

public interface GeneralDao<T, ID> {
    void create(T entity);
    void Update(T entity);
    void delete(ID id);

    T getById();
    List<T> getAll();
}
