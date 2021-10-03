package com.example.database.P41_HQL_UpdateDeleteInsert;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class MainLoad {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            // Update
//            session.createQuery("update Student s set s.name='Peter' where id = 1").executeUpdate();

            // Insert
//            session.createQuery("insert into Student(id, name)").executeUpdate();

            // Delete
            session.createQuery("delete Student s where id = 1").executeUpdate();


            session.getTransaction().commit();

        }

    }
}
