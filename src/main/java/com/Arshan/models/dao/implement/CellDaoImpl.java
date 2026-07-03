package com.Arshan.models.dao.implement;

import com.Arshan.models.dao.CellDao;
import com.Arshan.models.database.DataBaseManager;
import com.Arshan.models.entity.Cell;
import com.Arshan.models.entity.Prisoner;
import com.Arshan.models.exceptions.NotFound;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CellDaoImpl implements CellDao {
    @Override
    public void create(Cell entity) {
        String sql = "INSERT INTO Cell(cell_number, capacity, block_id) VALUES(?,?,?)";
        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, entity.getCellNumber());
            ps.setInt(2, entity.getCapacity());
            ps.setInt(3, entity.getBlockId());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void Update(Cell entity, Integer integer) {
        String sql = "UPDATE Cell SET capacity = ?, block_id = ? WHERE id = ?";
        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, entity.getCapacity());
            ps.setInt(2, entity.getBlockId());
            ps.setInt(3, integer);
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Integer getRemaining(Integer id) {
        String sql = "SELECT c.capacity - COUNT(p.id) AS remaining FROM Cell c LEFT JOIN Prisoner p ON p.cell_id = c.id WHERE c.id = ? GROUP BY c.id, c.capacity";
        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("remaining");
            } else {
                throw new NotFound();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public HashSet<Prisoner> getPrisoners(Integer cellId) {
        String sql = "SELECT * FROM prisoners where cell_id = ?";
        HashSet<Prisoner> currentPrisoners = new HashSet<>();
        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            PrisonerDaoImpl prisonerImpl = new PrisonerDaoImpl();
            ps.setInt(1, cellId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                currentPrisoners.add(prisonerImpl.map(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return currentPrisoners;
    }

    @Override
    public List<Cell> getEmptyCell() {
        String sql = "SELECT C.* FROM Cell c LEFT JOIN Prisoner p ON  c.id = p.cell_id GROUP BY c.id, p.id HAVING COUNT(p.id) < c.capacity";
        List<Cell> emptyCells = new ArrayList<>();
        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                emptyCells.add(map(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return emptyCells;
    }

    public Cell map(ResultSet rs) throws SQLException{
        return new Cell(
                rs.getInt("id"),
                rs.getInt("cell_number"),
                rs.getInt("capacity"),
                getPrisoners(rs.getInt("id")),
                rs.getInt("block_id")
        );
    }

    @Override
    public int getPrisonerCount(int cellId) {
        String sql = "SELECT COUNT(id) FROM prisoners where cell_id = ?";
        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cellId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("count");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return 0;
    }

    @Override
    public List<Cell> getFullCell() {
        String sql = "SELECT c.*, count(p.id) FROM Cell c INNER JOIN Prisoner p ON c.id = p.cell_id group by c.id HAVING count(p.id) >= c.capacity";
        List<Cell> fullCells = new ArrayList<>();
        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                fullCells.add(map(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return fullCells;
    }
}
