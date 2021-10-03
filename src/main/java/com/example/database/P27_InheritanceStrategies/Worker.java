package com.example.database.P27_InheritanceStrategies;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Worker extends Person {

    @Id
    @GeneratedValue
    int id;
    String job;

    public Worker() {
    }

    public Worker(String job) {
        this.job = job;
    }

    public Worker(int age, String job) {
        super(age);
        this.job = job;
    }
}
