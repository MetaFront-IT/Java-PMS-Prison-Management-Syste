package com.Arshan.models.dao;

import com.Arshan.models.entity.Visit;

import java.util.List;

public interface VisitDao {
    void create(Visit entity);
    void cancelVisit(int id);
    List<Visit> getAll();
}
