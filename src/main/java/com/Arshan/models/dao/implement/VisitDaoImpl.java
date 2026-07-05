package com.Arshan.models.dao.implement;

import com.Arshan.models.dao.PrisonerDao;
import com.Arshan.models.dao.VisitDao;
import com.Arshan.models.database.DataBaseManager;
import com.Arshan.models.entity.Prisoner;
import com.Arshan.models.entity.Visit;
import com.Arshan.models.entity.enums.VisitStatus;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class VisitDaoImpl implements VisitDao {

    @Override
    public void create(Visit entity) {
        String sql = "INSERT INTO Visit(prisoner_id, visitor_id, visit_date, visit_time) values (?,?,?,?)";
        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, entity.getPrisonerId());
            ps.setInt(2, entity.getVisitorId());
            ps.setDate(3, Date.valueOf(entity.getVisitDate()));
            ps.setTime(4, Time.valueOf(entity.getVisitTime()));
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void cancelVisit(int id) {
        String sql = "UPDATE visit SET status = ? where id = ?";
        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, VisitStatus.CANCELLED.getString());
            ps.setInt(2,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Visit> getAll() {
        List<Visit> Visits = new ArrayList<>();
        String sql = "SELECT * from Visit";
        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Visits.add(new Visit(
                        rs.getInt("id"),
                        rs.getInt("prisoner_id"),
                        rs.getInt("visitor_id"),
                        rs.getDate("visit_date").toLocalDate(),
                        rs.getTime("visit_time").toLocalTime(),
                        VisitStatus.valueOf(rs.getString("status"))
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return Visits;
    }

    @Override
    public List<Prisoner> haveVisit() {
        List<Prisoner> haveVisit = new ArrayList<>();
        PrisonerDao prisonerDao = new PrisonerDaoImpl();
        LocalTime now = LocalTime.now();
        LocalDate today = LocalDate.now();
        String sql = "SELECT p.* ,v.visit_time FROM Prisoner p JOIN Visit v ON p.id=v.prisoner_id where v.visit_date = CURRENT_DATE AND v.visit_time > current_time";
        try (Connection conn = DataBaseManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                haveVisit.add(prisonerDao.map(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return haveVisit;
    }
}
