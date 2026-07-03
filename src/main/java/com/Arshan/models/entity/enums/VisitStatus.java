package com.Arshan.models.entity.enums;

public enum VisitStatus {
    ACTIVE("Active"),
    CANCELLED("cancelled");

    private final String status;
    VisitStatus(String status) {
        this.status = status;
    }

    public String getString() {
        return status;
    }
}
