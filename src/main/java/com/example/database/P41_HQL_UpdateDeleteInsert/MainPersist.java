package com.example.database.P41_HQL_UpdateDeleteInsert;

import com.example.database.P40_HQL_Function.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class MainPersist {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            com.example.database.P40_HQL_Function.Student student = new Student("Pete");
            session.save(student);

            session.getTransaction().commit();

        }

    }
}
