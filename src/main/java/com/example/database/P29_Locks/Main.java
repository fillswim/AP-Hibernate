package com.example.database.P29_Locks;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            Student student = new Student("1");
            session.save(student);

            session.getTransaction().commit();

            // Перезаписывание данных в БД
            session.beginTransaction();
            Student loadStudent = session.load(Student.class, 1);
            loadStudent.setNumber("5");
            session.getTransaction().commit();


        }

    }
}
