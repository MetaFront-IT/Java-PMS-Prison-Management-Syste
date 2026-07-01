package com.Arshan.models.entity.enums;

public enum PrisonerStatus {
    ACTIVE("Active"),
    RELEASED("Released"),
    TRANSFERRED("Transferred");

    private final String status;
    PrisonerStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
