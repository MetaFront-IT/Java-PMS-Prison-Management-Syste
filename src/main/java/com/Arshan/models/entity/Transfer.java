package com.Arshan.models.entity;

import java.time.LocalDate;

public class Transfer {
    private int id;
    private int prisonerId;
    private int fromCell;
    private int toCell;
    private int guardId;
    private LocalDate transferDate;
    private String Description;

    public Transfer(int prisonerId, int fromCell, int toCell, int guardId, LocalDate transferDate, String description) {
        this.prisonerId = prisonerId;
        this.fromCell = fromCell;
        this.toCell = toCell;
        this.guardId = guardId;
        this.transferDate = transferDate;
        Description = description;
    }

    public Transfer(int id, int prisonerId, int fromCell, int toCell, int guardId, LocalDate transferDate, String description) {
        this.id = id;
        this(prisonerId, fromCell, toCell, guardId, transferDate, description);
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

    public int getFromCell() {
        return fromCell;
    }

    public void setFromCell(int fromCell) {
        this.fromCell = fromCell;
    }

    public int getToCell() {
        return toCell;
    }

    public void setToCell(int toCell) {
        this.toCell = toCell;
    }

    public int getGuardId() {
        return guardId;
    }

    public void setGuardId(int guardId) {
        this.guardId = guardId;
    }

    public LocalDate getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDate transferDate) {
        this.transferDate = transferDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "id=" + id +
                ", prisonerId=" + prisonerId +
                ", fromCell=" + fromCell +
                ", toCell=" + toCell +
                ", guardId=" + guardId +
                ", transferDate=" + transferDate +
                ", Description='" + Description + '\'' +
                '}';
    }
}
