package com.Arshan.models.entity;

import com.Arshan.models.entity.enums.Gender;
import com.Arshan.models.entity.enums.PrisonerStatus;

import java.time.LocalDate;

public class Prisoner {
    private int id;
    private String firstName;
    private String lastName;
    private String nationalCode;
    private LocalDate birthDate;
    private Gender gender;
    private PrisonerStatus status;
    private int sentenceId;
    private int cellID;

    public Prisoner(String firstName, String lastName, String nationalCode, LocalDate birthDate, Gender gender, PrisonerStatus status, int sentenceId ,int cellID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.birthDate = birthDate;
        this.gender = gender;
        this.status = status;
        this.sentenceId = sentenceId;
        this.cellID = cellID;
    }
    public Prisoner(int id, String firstName, String lastName, String nationalCode, LocalDate birthDate, Gender gender, PrisonerStatus status, int sentenceId ,int cellID) {
        this.id = id;
        this(firstName, lastName, nationalCode, birthDate, gender, status, sentenceId, cellID);
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public PrisonerStatus getStatus() {
        return status;
    }

    public void setStatus(PrisonerStatus status) {
        this.status = status;
    }

    public int getSentenceId() {
        return sentenceId;
    }

    public void setSentenceId(int sentenceId) {
        this.sentenceId = sentenceId;
    }

    public int getCellID() {
        return cellID;
    }

    public void setCellID(int cellID) {
        this.cellID = cellID;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Prisoner{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                ", status=" + status +
                '}' + "\n";
    }
}
