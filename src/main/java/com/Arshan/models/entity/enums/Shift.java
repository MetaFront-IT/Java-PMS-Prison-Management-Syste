package com.Arshan.models.entity.enums;

public enum Shift {
    MORNING("Morning"),
    EVENING("Evening"),
    NIGHT("Night");

    private final String shift;
    Shift(String shift) {
        this.shift = shift;
    }

    public String getShift() {
        return shift;
    }
}
