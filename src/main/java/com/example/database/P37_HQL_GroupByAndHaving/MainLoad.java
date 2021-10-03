package com.example.database.P37_HQL_GroupByAndHaving;

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

            // Группировка по имени (будут выведены названия групп объектов)
//            Query query = session.createQuery("select s.name from Student s group by s.name");

            // Группировка по имени с условием
            Query query = session.createQuery(
                    "select s.name from Student s group by s.name having length(s.name)>3");

            List<String> names = query.list();
            for (String name : names) {
                System.out.println(name);
            }

            session.getTransaction().commit();

        }

    }
}
