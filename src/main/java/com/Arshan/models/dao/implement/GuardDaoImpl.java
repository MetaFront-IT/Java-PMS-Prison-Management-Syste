package com.Arshan.models.dao.implement;

import com.Arshan.models.dao.GuardDao;
import com.Arshan.models.database.DataBaseManager;
import com.Arshan.models.entity.Guard;
import com.Arshan.models.entity.enums.Shift;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class GuardDaoImpl implements GuardDao {
    @Override
    public void create(Guard entity) {
        String sql = "INSERT INTO Guard(first_name, last_name, national_code, shift, block_id) values (?,?,?,?,?)";
        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());
            ps.setString(3, entity.getNationalCode());
            ps.setString(4, entity.getShift().getString());
            ps.setInt(5, entity.getBlockId());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void Update(Guard entity, Integer integer) {
        String sql = "UPDATE Guard SET first_name = ?, last_name = ?, national_code = ?, shift = ? , block_id = ?";
        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public Guard getById(Integer integer) {
        return null;
    }

    @Override
    public List<Guard> getAll() {
        return List.of();
    }

    @Override
    public Guard map(ResultSet rs) throws SQLException {
        return null;
    }

    @Override
    public void setBlock() {

    }

    @Override
    public HashMap<String, Shift> getShift() {
        return null;
    }
}
