package com.Arshan.models.dao.implement;

import com.Arshan.models.dao.BlockDao;
import com.Arshan.models.database.DataBaseManager;
import com.Arshan.models.entity.Block;
import com.Arshan.models.entity.Cell;
import com.Arshan.models.exceptions.NotFound;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BlockDaoImpl implements BlockDao {
    public void create(Block entity){
        String sql = "INSERT INTO block(name) values (?)";
        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, entity.getName());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE from block where id = ?";
        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Cell> getCells(int id) {
        String sql = "SELECT c.*, b.*, count(p.id) as PrisonersCount FROM cell c INNER JOIN Block b ON c.block_id = b.id LEFT JOIN Prisoner p ON c.id = p.cell_id where b.id = ? GROUP BY c.id, c.cell_number, b.id, b.name order by PrisonersCount DESC;\n";
        List<Cell> cells = new ArrayList<>();
        try(Connection conn = DataBaseManager.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            CellDaoImpl cellDao = new CellDaoImpl();
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cells.add(cellDao.map(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return cells;
    }

    @Override
    public int getPrisonersCount(int id) {
        String sql = "SELECT COUNT(p.id) FROM prisoner p INNER JOIN Cell c ON p.cell_id = c.id LEFT JOIN Block b ON c.block_id = b.id where b.id = ?";
        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("count");
            } else {
                throw new NotFound();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public int getAverageCount() {
        String sql = "SELECT avg(prisonerCountPerBlock) FROM (SELECT b.id, COUNT(p.id) AS prisonerCountPerBlock FROM Block b LEFT JOIN Cell c ON c.block_id = b.id  LEFT JOIN prisoner p ON p.cell_id = c.id GROUP BY b.id) AS Block;";
        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("avg");
            } else {
                throw new NotFound();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public int getMaxCount() {
        String sql = "SELECT max(prisonerCountPerBlock) FROM (SELECT b.id, COUNT(p.id) AS prisonerCountPerBlock FROM Block b LEFT JOIN Cell c ON c.block_id = b.id LEFT JOIN prisoner p ON p.cell_id = c.id GROUP BY b.id) AS Block";
        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("max");
            } else {
                throw new NotFound();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public int getMinCount() {
        String sql = "SELECT min(prisonerCountPerBlock) FROM (SELECT b.id, COUNT(p.id) AS prisonerCountPerBlock FROM Block b LEFT JOIN Cell c ON c.block_id = b.id LEFT JOIN prisoner p ON p.cell_id = c.id GROUP BY b.id) AS Block";
        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("min");
            } else {
                throw new NotFound();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
