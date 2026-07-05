package com.Arshan.models.entity;

import com.Arshan.models.entity.enums.VisitStatus;

import java.time.LocalDate;
import java.time.LocalTime;

public class Visit {
    private int id;
    private int prisonerId;
    private int visitorId;
    private LocalDate visitDate;
    private LocalTime visitTime;
    private VisitStatus status;

    public Visit(int prisonerId, int visitorId, LocalDate visitDate, LocalTime visitTime, VisitStatus status) {
        this.prisonerId = prisonerId;
        this.visitorId = visitorId;
        this.visitDate = visitDate;
        this.visitTime = visitTime;
        this.status = status;
    }

    public Visit(int id, int prisonerId, int visitorId, LocalDate visitDate, LocalTime visitTime, VisitStatus status) {
        this.id = id;
        this(prisonerId, visitorId, visitDate, visitTime, status);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrisonerId() {
        return prisonerId;
    }

    public void setPrisonerId(int prisonerId) {
        this.prisonerId = prisonerId;
    }

    public int getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(int visitorId) {
        this.visitorId = visitorId;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public LocalTime getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(LocalTime visitTime) {
        this.visitTime = visitTime;
    }

    public VisitStatus getStatus() {
        return status;
    }

    public void setStatus(VisitStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", prisonerId=" + prisonerId +
                ", visitorId=" + visitorId +
                ", visitDate=" + visitDate +
                ", visitTime=" + visitTime +
                ", status=" + status +
                '}';
    }
}
