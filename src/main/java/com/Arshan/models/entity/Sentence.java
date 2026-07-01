package com.Arshan.models.entity;

import com.Arshan.models.entity.enums.SentenceStatus;

import java.time.LocalDate;

public class Sentence {
    private int id;
    private int crimeId;
    private int prisonerId;
    private LocalDate startDate;
    private LocalDate endDate;
    private SentenceStatus status;

    public Sentence(int crimeId, int prisonerId, LocalDate startDate, LocalDate endDate) {
        this.crimeId = crimeId;
        this.prisonerId = prisonerId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public Sentence(int id, int crimeId, int prisonerId, LocalDate startDate, LocalDate endDate, SentenceStatus status) {
        this.id = id;
        this(crimeId, prisonerId, startDate, endDate);
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCrimeId() {
        return crimeId;
    }

    public void setCrimeId(int crimeId) {
        this.crimeId = crimeId;
    }

    public int getPrisonerId() {
        return prisonerId;
    }

    public void setPrisonerId(int prisonerId) {
        this.prisonerId = prisonerId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public SentenceStatus getStatus() {
        return status;
    }

    public void setStatus(SentenceStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "id=" + id +
                ", crimeid=" + crimeId +
                ", prisonerid=" + prisonerId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                '}';
    }
}
