package com.example.database.P25_NaturalId;


import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue
    int id;

    @NaturalId // Дополнительный Id
    String iCode;

    String name;

    public Student() {
    }

    public Student(String iCode, String name) {
        this.iCode = iCode;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", iCode='" + iCode + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
