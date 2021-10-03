package com.example.database.P31_HQL;

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

            // Вывод всех студентов
//            Query query = session.createQuery("from Student ");
//            List<Student> students = query.list();

            // Вывод одного студента
            Query query = session.createQuery("from Student where name = 'Mike'");
            Student student = (Student) query.uniqueResult();
            System.out.println(student);

            session.getTransaction().commit();

        }

    }
}
