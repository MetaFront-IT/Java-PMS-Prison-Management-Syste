package com.Arshan.models.dao;

import com.Arshan.models.entity.Prisoner;
import com.Arshan.models.entity.Visit;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface VisitDao {
    void create(Visit entity);
    void cancelVisit(int id);
    List<Visit> getAll();
    List<Prisoner> haveVisit();
}
