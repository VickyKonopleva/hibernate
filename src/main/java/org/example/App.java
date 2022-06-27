package org.example;

import org.example.model.Person;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sessionFactory = null;
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Person person1 = new Person("Ross", "Korol", (byte)24);
            Person person2 = new Person("Fedor", "Dostoevsky", (byte)150);
            Person person3 = new Person("Leo", "Tolsatoy", (byte)180);
            session.persist(person1);
            session.persist(person2);
            session.persist(person3);
//            Person person = session.get(Person.class, 1);
//            System.out.println(person.getName());
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
