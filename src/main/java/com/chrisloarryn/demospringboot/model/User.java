package com.chrisloarryn.demospringboot.model;

import java.util.UUID;

public class User {
    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final Gender gender;
    private final Integer age;
    private final String email;

    public User(UUID id, String firstName, String lastName, Gender gender, Integer age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    public enum Gender {
        Male,
        Female
    }
}
