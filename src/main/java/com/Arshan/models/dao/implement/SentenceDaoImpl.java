package com.Arshan.models.dao.implement;

import com.Arshan.models.dao.PrisonerDao;
import com.Arshan.models.dao.SentenceDao;
import com.Arshan.models.database.DataBaseManager;
import com.Arshan.models.entity.Prisoner;
import com.Arshan.models.entity.Sentence;
import com.Arshan.models.entity.enums.SentenceStatus;
import com.Arshan.models.exceptions.NotFound;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SentenceDaoImpl implements SentenceDao {
    @Override
    public void create(Sentence entity) {
        String sql = "INSERT INTO Sentences(crime_id, start_date, end_date, status) values (?,?,?,?)";
        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, entity.getCrimeId());
            ps.setDate(2, Date.valueOf(entity.getStartDate()));
            ps.setDate(3, Date.valueOf(entity.getEndDate()));
            ps.setString(4, entity.getStatus().getString());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Sentence getById(int id) {
        String sql = "SELECT * FROM Sentences where id = ?";
        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Sentence(
                        rs.getInt("id"),
                        rs.getInt("crime_id"),
                        rs.getDate("start_date").toLocalDate(),
                        rs.getDate("end_date").toLocalDate(),
                        SentenceStatus.valueOf(rs.getString("status"))
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public int getDuration(int id) {
        String sql = "SELECT SUM(end_date - start_date) AS duration FROM Sentences where id = ?;";
        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("duration") / 30;
            }
            else throw new NotFound();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Prisoner> isEnding() {
            String sql = "SELECT p.* FROM Sentences s LEFT JOIN prisoner p ON p.sentence_id = s.id where end_date < current_date + 5 AND p.status != 'Completed'";
        List<Prisoner> isEnding = new ArrayList<>();
        PrisonerDao prisonerDao = new PrisonerDaoImpl();
        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                isEnding.add(prisonerDao.map(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return isEnding;
    }
}
