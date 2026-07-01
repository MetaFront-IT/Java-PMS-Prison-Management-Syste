package com.Arshan.models.entity;

import java.time.LocalDate;

public class Visit {
    private int id;
    private int prisonerId;
    private int visitorId;
    private LocalDate visitDate;
    private LocalDate visitTime;

    public Visit(int prisonerId, int visitorId, LocalDate visitDate, LocalDate visitTime) {
        this.prisonerId = prisonerId;
        this.visitorId = visitorId;
        this.visitDate = visitDate;
        this.visitTime = visitTime;
    }

    public Visit(int id, int prisonerId, int visitorId, LocalDate visitDate, LocalDate visitTime) {
        this.id = id;
        this(prisonerId, visitorId, visitDate, visitTime);
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

    public LocalDate getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(LocalDate visitTime) {
        this.visitTime = visitTime;
    }
}
