package com.Arshan.models.entity;

import java.util.HashSet;

public class Cell {
    private int id;
    private int cellNumber;
    private int capacity;
    private HashSet<Prisoner> CurrentPrisoners;
    private int blockId;

    public Cell(int cellNumber, int capacity, int blockId) {
        this.cellNumber = cellNumber;
        this.capacity = capacity;
        this.blockId = blockId;
    }

    public Cell(int cellNumber, int capacity, HashSet<Prisoner> currentPrisoners, int blockId) {
        this.CurrentPrisoners = currentPrisoners;
        this(cellNumber, capacity, blockId);
    }

    public Cell(int id, int cellNumber, int capacity, HashSet<Prisoner> currentPrisoners, int blockId) {
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

    public HashSet<Prisoner> getCurrentPrisoners() {
        return CurrentPrisoners;
    }

    public void setCurrentPrisoners(HashSet<Prisoner> currentPrisoners) {
        CurrentPrisoners = currentPrisoners;
    }

    public int getBlockId() {
        return blockId;
    }

    public void setBlockId(int blockId) {
        this.blockId = blockId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
