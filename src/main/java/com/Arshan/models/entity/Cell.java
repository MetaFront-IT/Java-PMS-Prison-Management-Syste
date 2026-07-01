package com.Arshan.models.entity;

import java.util.List;

public class Cell {
    private int id;
    private int cellNumber;
    private int capacity;
    private List<Prisoner> CurrentPrisoners;
    private int blockId;

    public Cell(int cellNumber, int capacity, List<Prisoner> currentPrisoners, int blockId) {
        this.cellNumber = cellNumber;
        this.capacity = capacity;
        CurrentPrisoners = currentPrisoners;
        this.blockId = blockId;
    }

    public Cell(int id, int cellNumber, int capacity, List<Prisoner> currentPrisoners, int blockId) {
        this.id = id;
        this(cellNumber, capacity, currentPrisoners, blockId);
    }

    public int getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(int cellNumber) {
        this.cellNumber = cellNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Prisoner> getCurrentPrisoners() {
        return CurrentPrisoners;
    }

    public void setCurrentPrisoners(List<Prisoner> currentPrisoners) {
        CurrentPrisoners = currentPrisoners;
    }

    public int getBlockId() {
        return blockId;
    }

    public void setBlockId(int blockId) {
        this.blockId = blockId;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "cellNumber=" + cellNumber +
                ", capacity=" + capacity +"," +
                " blockId=" + blockId + "\n" +
                ", currentPrisoners=" + "\n\t" + CurrentPrisoners +
                '}';
    }
}
