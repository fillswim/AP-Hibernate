package com.example.database.P23_Collections.C3_BasicCollections;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class MainLoad {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            // Загрузка значений из БД
            Student loadStudent = session.load(Student.class, 1);
            List<Integer> marks = loadStudent.getMarks();
            System.out.println(loadStudent);
            System.out.println();
            System.out.println(marks);

            session.getTransaction().commit();

        }

    }
}
