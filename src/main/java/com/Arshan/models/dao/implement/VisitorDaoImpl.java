package com.Arshan.models.dao.implement;

import com.Arshan.models.dao.VisitorDao;
import com.Arshan.models.database.DataBaseManager;
import com.Arshan.models.entity.Visitor;
import com.Arshan.models.exceptions.NotFound;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VisitorDaoImpl implements VisitorDao {
    @Override
    public void create(Visitor entity) {
        String sql = "INSERT INTO visitor(first_name, last_name, national_code, relation_to_prisoner) values(?,?,?,?)";
        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());
            ps.setString(3, entity.getNationalCode());
            ps.setString(4, entity.getRelationToPrisoner());

            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Visitor getById(int id) {
        String sql = "SELECT * FROM Visitor WHERE id = ?";
        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Visitor(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("national_code"), rs.getString("relation_to_prisoner"));
            } else {
                throw new NotFound();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
