package com.Arshan.models.dao;

import com.Arshan.models.entity.Prisoner;
import com.Arshan.models.entity.Transfer;

import java.time.LocalDate;
import java.util.List;

public interface PrisonerDao extends GeneralDao<Prisoner, Integer> {
    List<Prisoner> search(String string);
    Transfer transfer(int prisonerId, int fromCell, int toCell, int guardId, LocalDate transferDate, String description);
}
