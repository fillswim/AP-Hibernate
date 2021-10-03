package com.example.database.P05_Column;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue
    int id;

    // Переименование поля в БД, уникальность значний
    @Column(name = "StudentName", unique = true)
    String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }
}
