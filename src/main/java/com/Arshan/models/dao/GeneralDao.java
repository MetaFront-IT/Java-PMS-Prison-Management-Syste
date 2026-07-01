package com.Arshan.models.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface GeneralDao<T, ID> {
    void create(T entity);
    void Update(T entity , ID id);
    void delete(ID id);

    T getById(ID id);
    List<T> getAll();
    T map(ResultSet rs) throws SQLException;
}
