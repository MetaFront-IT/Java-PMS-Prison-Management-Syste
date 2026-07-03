package com.Arshan.models.dao;

import com.Arshan.models.entity.Visitor;

public interface VisitorDao {
    void create(Visitor entity);

    Visitor getById(int id);
}
