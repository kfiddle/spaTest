package com.example.demo.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {
    @Id
    @GeneratedValue

    private Long id;

    private String firstName;
    private String lastName;

    public Person() {
    }

    public Person(String fName, String lName) {
        firstName = fName;
        lastName = lName;
    }

    public Person(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


}
