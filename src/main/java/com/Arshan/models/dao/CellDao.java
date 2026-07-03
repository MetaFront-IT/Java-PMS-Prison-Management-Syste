package com.Arshan.models.dao;

import com.Arshan.models.entity.Cell;
import com.Arshan.models.entity.Prisoner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;

public interface CellDao{
    void create(Cell entity);
    void Update(Cell entity , Integer id);

    Integer getRemaining(Integer id);
    HashSet<Prisoner> getPrisoners(Integer id);
    List<Cell> getEmptyCell();
    List<Cell> getFullCell();
    Cell map(ResultSet rs) throws SQLException;
    int getPrisonerCount(int cellId);

}
