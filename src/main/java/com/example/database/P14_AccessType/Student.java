package com.example.database.P14_AccessType;


import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue
    int id;

    // Данные будут читаться через
    // AccessType.FIELD - поля, минуя геттеры и сеттеры
    // AccessType.PROPERTY - через геттеры и сеттеры
    @Access(AccessType.FIELD)
    String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return "Mr. " + name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
