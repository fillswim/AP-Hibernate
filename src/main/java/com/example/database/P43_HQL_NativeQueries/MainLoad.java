package com.example.database.P43_HQL_NativeQueries;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class MainLoad {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            // Запуск запроса на SQL с получением Object
//            NativeQuery nativeQuery = session.createNativeQuery("select * from Student");
//            List<Object[]> students = nativeQuery.getResultList();
//
//            for (Object[] objects : students) {
//                int id = (int) objects[0];
//                System.out.print(id + " ");
//                String name = (String) objects[1];
//                System.out.println(name);
//            }

            // Запуск запроса на SQL с получением Student
            NativeQuery nativeQuery = session.createNativeQuery("select * from Student", Student.class);
            List<Student> students = nativeQuery.getResultList();

            for (Student student : students) {
                System.out.println(student);
            }


            session.getTransaction().commit();

        }

    }
}
