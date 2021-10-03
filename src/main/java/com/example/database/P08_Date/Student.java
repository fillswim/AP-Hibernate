package com.example.database.P08_Date;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Student {

    @Id
    @GeneratedValue
    int id;
    String name;

    // Сохранение даты в виде
    // TemporalType.DATE - даты
    // TemporalType.TIME - времени
    // TemporalType.TIMESTAMP - даты и времени
    @Temporal(TemporalType.TIME)
    Date date;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, Date date) {
        this.name = name;
        this.date = date;
    }
}
