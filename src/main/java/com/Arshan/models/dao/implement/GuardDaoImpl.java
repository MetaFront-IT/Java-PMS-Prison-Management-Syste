package com.Arshan.models.dao.implement;

import com.Arshan.models.dao.GuardDao;
import com.Arshan.models.database.DataBaseManager;
import com.Arshan.models.entity.Guard;
import com.Arshan.models.entity.enums.Shift;
import com.Arshan.models.exceptions.NotFound;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public void Update(Guard entity, Integer id) {
        String sql = "UPDATE Guard SET first_name = ?, last_name = ?, national_code = ?, shift = ? , block_id = ? WHERE id = ?";
        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());
            ps.setString(3, entity.getNationalCode());
            ps.setString(4, entity.getShift().getString());
            ps.setInt(5, entity.getBlockId());
            ps.setInt(6, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from Guard where id = ?";
        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public Guard getById(Integer id) {
        String sql = "SELECT * FROM Guard where id = ?";
        try(Connection conn = DataBaseManager.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return map(rs);
            }
            else {
                throw new NotFound();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Guard> getAll() {
        String sql = "SELECT * FROM guard";
        List<Guard> guards = new ArrayList<>();
        try(Connection conn = DataBaseManager.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                guards.add(map(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return guards;
    }

    @Override
    public void setBlock(Integer id, Integer blockId) {
        String sql = "UPDATE Guard SET block_id = ? WHERE id = ?";
        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, blockId);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public HashMap<String, Shift> getShift() {
        String sql = "SELECT first_name, last_name, shift from Guard";
        HashMap<String, Shift> guardShift = new HashMap<>();
        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                guardShift.put(rs.getString("first_name") + " " + rs.getString("last_name"), Shift.valueOf(rs.getString("shift")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return guardShift;
    }

    @Override
    public Guard map(ResultSet rs) throws SQLException {
        return new Guard(
                rs.getInt("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("national_code"),
                Shift.valueOf(rs.getString("shift")),
                rs.getInt("block_id")
        );
    }
}
