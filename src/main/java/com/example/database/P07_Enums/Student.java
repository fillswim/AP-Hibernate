package com.example.database.P07_Enums;


import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue
    int id;
    String name;

    // Значение будет храниться в виде
    // EnumType.STRING - строки
    // EnumType.ORDINAL - в виде числа (по умолчанию)
    @Enumerated(value = EnumType.STRING)
    Days days;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, Days days) {
        this.name = name;
        this.days = days;
    }

    public Days getDays() {
        return days;
    }

    public void setDays(Days days) {
        this.days = days;
    }
}
