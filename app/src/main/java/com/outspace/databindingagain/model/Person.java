package com.outspace.databindingagain.model;

// POJO for a base person's class.

public class Person {
    private String firstName;
    private String lastName;
    private String birthDay;
    private String coolPhrase;

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

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getCoolPhrase() {
        return coolPhrase;
    }

    public void setCoolPhrase(String coolPhrase) {
        this.coolPhrase = coolPhrase;
    }
}
