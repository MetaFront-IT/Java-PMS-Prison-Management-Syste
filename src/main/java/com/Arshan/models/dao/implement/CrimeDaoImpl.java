package com.Arshan.models.dao.implement;

import com.Arshan.models.dao.CrimeDao;
import com.Arshan.models.database.DataBaseManager;
import com.Arshan.models.entity.Crime;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrimeDaoImpl implements CrimeDao {
    @Override
    public void create(Crime entity) {
        String sql = "INSERT INTO Crime(title) values (?)";
        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, entity.getTitle());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(Crime entity, int id) {
        String sql = "UPDATE Crime SET title = ? where id = ?";
        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, entity.getTitle());
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Crime> getAll() {
        String sql = "SELECT * from Crime";
        List<Crime> crimes= new ArrayList<>();
        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                crimes.add(new Crime(
                        rs.getInt("id"),
                        rs.getString("title")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return crimes;
    }
}
