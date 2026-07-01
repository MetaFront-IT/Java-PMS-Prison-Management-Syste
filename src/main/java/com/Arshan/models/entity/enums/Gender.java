package com.Arshan.models.entity.enums;

public enum Gender {
    MALE("Male"),
    Female("Female");


    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
