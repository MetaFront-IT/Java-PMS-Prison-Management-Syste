package com.Arshan.models.entity;

import com.Arshan.models.entity.enums.SentenceStatus;

import java.time.LocalDate;

public class Sentence {
    private int id;
    private int crimeId;
    private LocalDate startDate;
    private LocalDate endDate;
    private SentenceStatus status;

    public Sentence(int crimeId, LocalDate startDate, LocalDate endDate, SentenceStatus status) {
        this.crimeId = crimeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }
    public Sentence(int id, int crimeId, LocalDate startDate, LocalDate endDate, SentenceStatus status) {
        this.id = id;
        this(crimeId, startDate, endDate, status);
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
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                '}';
    }
}
