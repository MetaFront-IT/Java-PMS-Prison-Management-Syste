package com.Arshan.models.dao.implement;

import com.Arshan.models.dao.PrisonerDao;
import com.Arshan.models.database.DataBaseManager;
import com.Arshan.models.entity.Prisoner;
import com.Arshan.models.entity.Transfer;
import com.Arshan.models.entity.enums.Gender;
import com.Arshan.models.entity.enums.PrisonerStatus;
import com.Arshan.models.exceptions.NotFound;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PrisonerImpl implements PrisonerDao {
    @Override
    public void create(Prisoner entity) {
        String sql = "INSERT INTO Prisoner(first_name, last_name, national_code, birth_date, gender, status, sentence_id, cell_id) VALUES(?,?,?,?,?,?,?,?)";
        try(Connection conn = DataBaseManager.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());
            ps.setString(3, entity.getNationalCode());

            ps.setDate(4, Date.valueOf(entity.getBirthDate()));
            ps.setString(5, entity.getGender().getString());
            ps.setString(6, entity.getStatus().getString());
            ps.setInt(7, entity.getSentenceId());
            ps.setInt(8, entity.getCellID());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void Update(Prisoner entity, Integer id) {
        String sql = "UPDATE prisoner SET first_name = ?, last_name = ?, national_code = ?, birth_date = ?, gender = ? ,status = ?, sentence_id = ?, cell_id = ? WHERE id = ?";
        try(Connection conn = DataBaseManager.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());
            ps.setString(3, entity.getNationalCode());

            ps.setDate(4, Date.valueOf(entity.getBirthDate()));
            ps.setString(5, entity.getGender().getString());
            ps.setString(6, entity.getStatus().getString());
            ps.setInt(7, entity.getSentenceId());
            ps.setInt(8, entity.getCellID());
            ps.setInt(9, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM prisoner where id = ?";
        try(Connection conn = DataBaseManager.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Prisoner getById(Integer id) {
        String sql = "SELECT * FROM prisoner where id = ?";
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
    public List<Prisoner> getAll() {
        String sql = "SELECT * FROM prisoner";
        List<Prisoner> prisoners = new ArrayList<>();
        try(Connection conn = DataBaseManager.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                prisoners.add(map(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return prisoners;
    }

    @Override
    public HashMap<Integer, String> search(String string) {
        String sql = "SELECT * FROM prisoner where (first_name|| ' ' || last_name) ILIKE ?";
        HashMap<Integer, String> prisoners = new HashMap<>();
        try(Connection conn = DataBaseManager.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + string + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                prisoners.put(rs.getInt("id"), rs.getString("first_name") + " " + rs.getString("last_name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return prisoners;
    }

    @Override
    public Transfer transfer(int prisonerId, int fromCell, int toCell, int guardId, LocalDate transferDate, String description) {
        String sql = "INSERT into  transfer(prisoner_id, from_cell, to_cell, guard_id, transfer_date, description) values (?,?,?,?,?,?)";
        String innerSql = "UPDATE Prisoner SET cell_id = ? where id = ?";
        try (Connection conn = DataBaseManager.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        PreparedStatement innerPS = conn.prepareStatement(innerSql)) {
            conn.setAutoCommit(false);

            innerPS.setInt(1, toCell);
            innerPS.setInt(2, prisonerId);

            ps.setInt(1, prisonerId);
            ps.setInt(2, fromCell);
            ps.setInt(3, toCell);
            ps.setInt(4, guardId);
            ps.setDate(5, Date.valueOf(transferDate));
            ps.setString(6, description);
            ps.executeUpdate();
            innerPS.executeUpdate();

            conn.commit();
            return new Transfer(prisonerId, fromCell, toCell, guardId, transferDate, description);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Prisoner map(ResultSet rs) throws SQLException{
        return new Prisoner(
                rs.getInt("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("national_code"),
                rs.getDate("birth_date").toLocalDate(),
                Gender.valueOf(rs.getString("gender")),
                PrisonerStatus.valueOf(rs.getString("status")),
                rs.getInt("sentence_id"),
                rs.getInt("cell_id")
        );
    }
}
