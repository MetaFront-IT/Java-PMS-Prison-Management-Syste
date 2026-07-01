package com.Arshan.models.dao.implement;

import com.Arshan.models.dao.PrisonerDao;
import com.Arshan.models.entity.Prisoner;
import com.Arshan.models.entity.Transfer;

import java.time.LocalDate;
import java.util.List;

public class PrisonerImpl implements PrisonerDao {
    @Override
    public void create(Prisoner entity) {
        String sql = "INSERT INTO ";
    }

    @Override
    public void Update(Prisoner entity) {

    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public Prisoner getById() {
        return null;
    }

    @Override
    public List<Prisoner> getAll() {
        return List.of();
    }

    @Override
    public List<Prisoner> search(String string) {
        return List.of();
    }

    @Override
    public Transfer transfer(int prisonerId, int fromCell, int toCell, int guardId, LocalDate transferDate, String description) {
        return null;
    }
}
