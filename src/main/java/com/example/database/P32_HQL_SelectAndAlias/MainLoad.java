package com.example.database.P32_HQL_SelectAndAlias;

import com.example.database.P31_HQL.Student;
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

            // Вывод одного студента
            Query query = session.createQuery("from Student as s where s.name = 'Mike'");
            Student student = (Student) query.uniqueResult();
            System.out.println(student);

            session.getTransaction().commit();

        }

    }
}
