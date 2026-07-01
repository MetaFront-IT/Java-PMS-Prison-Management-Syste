package com.Arshan.models.entity.enums;

public enum SentenceStatus {
    ACTIVE("Active"),
    FINISHED("Finished");

    private final String status;
    SentenceStatus(String status) {
        this.status = status;
    }
    public String getString() {
        return status;
    }
}
