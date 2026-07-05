package com.Arshan.models.entity;

public class Visitor {
    private int id;
    private String firstName;
    private String lastName;
    private String nationalCode;
    private String relationToPrisoner;

    public Visitor(String firstName, String lastName, String nationalCode, String relationToPrisoner) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.relationToPrisoner = relationToPrisoner;
    }

    public Visitor(int id, String firstName, String lastName, String nationalCode, String relationToPrisoner) {
        this.id = id;
        this(firstName, lastName, nationalCode, relationToPrisoner);
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

    public String getRelationToPrisoner() {
        return relationToPrisoner;
    }

    public void setRelationToPrisoner(String relationToPrisoner) {
        this.relationToPrisoner = relationToPrisoner;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", relationToPrisoner='" + relationToPrisoner + '\'' +
                '}';
    }
}
