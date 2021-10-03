package com.example.database.P33_HQL_Where;

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
//            Query query = session.createQuery("from Student where name = 'Mike' and id = 1");

            // Параметризированный запрос
//            Query query = session.createQuery("from Student where name = ?1 and id = ?2");
//            query.setParameter(1, "Mike");
//            query.setParameter(2, 1);

            // Именованные параметры
            Query query = session.createQuery("from Student where name = :number1 and id = :number2");
            query.setParameter("number1", "Mike");
            query.setParameter("number2", 1);


            Student student = (Student) query.uniqueResult();
            System.out.println(student);

            session.getTransaction().commit();

        }

    }
}
