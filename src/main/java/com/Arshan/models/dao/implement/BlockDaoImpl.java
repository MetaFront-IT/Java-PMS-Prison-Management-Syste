package com.Arshan.models.dao.implement;

import com.Arshan.models.dao.BlockDao;
import com.Arshan.models.database.DataBaseManager;
import com.Arshan.models.entity.Block;
import com.Arshan.models.entity.Cell;

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
            ps.execute()
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE from block() where id = ?";
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
        String sql = "SELECT c.*, b.*, count(p.id) as PrisonersCount\n" +
                "FROM cell c INNER JOIN Block b ON c.block_id = b.id LEFT JOIN Prisoner p ON c.id = p.cell_id where b.id = ?\n" +
                "GROUP BY c.id, c.cell_number, b.id, b.name\n" +
                "order by PrisonersCount DESC;";
        List<Cell> cells = new ArrayList<>();
        try(Connection conn = DataBaseManager.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            CellDaoImpl cellDao = new CellDaoImpl();
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cellDao.map(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return cells;
    }
}
