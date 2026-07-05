package com.Arshan.models.dao;

import com.Arshan.models.entity.Prisoner;
import com.Arshan.models.entity.Transfer;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public interface PrisonerDao extends GeneralDao<Prisoner, Integer> {
    HashMap<Integer ,String> search(String string);
    Transfer transfer(int prisonerId, int fromCell, int toCell, int guardId, LocalDate transferDate, String description);
    List<Prisoner> getByCrime(int id);
}
