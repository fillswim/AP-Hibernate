package com.example.database.P42_HQL_NamedQueries;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class MainLoad {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            // Запуск именованного запроса
            Query getStudentById = session.createNamedQuery("getStudentById");
            getStudentById.setParameter("id", 2);

            Student loadStudent = (Student) getStudentById.uniqueResult();
            System.out.println(loadStudent);


            session.getTransaction().commit();

        }

    }
}
