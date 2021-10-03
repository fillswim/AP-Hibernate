package com.example.database.P06_Type;


import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Student {

    @Id
    @GeneratedValue
    int id;

    // Определенеие типа для сохранения в БД
    @Type(type = "String")
    String name;

    @Type(type = "timestamp")
    Date date;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
