package com.Arshan.models.dao;

import com.Arshan.models.entity.Crime;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public interface CrimeDao {
    void create(Crime entity);
    void update(Crime entity, int id);
    List<Crime> getAll();
}
