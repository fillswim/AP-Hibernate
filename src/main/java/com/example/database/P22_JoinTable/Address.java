package com.example.database.P22_JoinTable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Address {

    @Id
    @GeneratedValue
    int id;

    String city;
    String street;

    @ManyToMany
    List<Student> students;

    public Address() {
    }

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
