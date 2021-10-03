package com.example.database.P23_Collections.C3_BasicCollections;


import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue
    int id;
    String name;

    @ElementCollection // Сохранение коллекции базовых типов
    List<Integer> marks;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}
