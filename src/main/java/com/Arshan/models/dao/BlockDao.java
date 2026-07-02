package com.Arshan.models.dao;

import com.Arshan.models.entity.Block;
import com.Arshan.models.entity.Cell;
import com.Arshan.models.entity.Prisoner;

import java.util.List;

public interface BlockDao {
    void create(Block entity);
    void delete(int id);

    List<Cell> getCells(int id);
}
