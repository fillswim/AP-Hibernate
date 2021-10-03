package com.example.database.P27_InheritanceStrategies;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student extends Person {

    @Id
    @GeneratedValue
    int id;
    String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(int age, String name) {
        super(age);
        this.name = name;
    }
}
