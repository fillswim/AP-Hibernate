package com.example.database.P24_SortCollections;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class MainPersist {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            List<Integer> marks = new ArrayList<>();
            marks.add(4);
            marks.add(1);
            marks.add(3);
            marks.add(5);

            Student student = new Student("Mike");
            student.setMarks(marks);

            session.persist(student);

            session.getTransaction().commit();

        }

    }
}
