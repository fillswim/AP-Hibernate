package com.example.database.P35_HQL_Pagination;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class MainLoad {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            // Выборка определенного количества студентов
            Query query = session.createQuery("from Student");
            // Определение размера выборки
            query.setMaxResults(2);

            // Определение начального элемента для выборки
            query.setFirstResult(1);

            List<Student> students = query.list();
            for (Student student : students) {
                System.out.println(student);
            }

            session.getTransaction().commit();

        }

    }
}
