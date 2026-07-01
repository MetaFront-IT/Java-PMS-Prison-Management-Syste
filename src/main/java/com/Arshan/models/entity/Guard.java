package com.Arshan.models.entity;

import com.Arshan.models.entity.enums.Shift;

public class Guard {
    private int id;
    private String firstName;
    private String lastName;
    private String nationalCode;
    private Shift shift;
    private int blockId;

    public Guard(String firstName, String lastName, String nationalCode, Shift shift, int blockId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.shift = shift;
        this.blockId = blockId;
    }

    public Guard(int id, String firstName, String lastName, String nationalCode, Shift shift, int blockId) {
        this.id = id;
        this(firstName, lastName, nationalCode, shift, blockId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public int getBlockId() {
        return blockId;
    }

    public void setBlockId(int blockId) {
        this.blockId = blockId;
    }


}
