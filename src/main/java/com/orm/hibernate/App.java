package com.orm.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.orm.hibernate.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project started..." );
        
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        
        // new Student creation
        Student student1 = new Student();
        student1.setId(1001);
        student1.setName("ABC");
        student1.setCity("Tokyo");
        
        System.out.println(student1);
        
        Session session = sessionFactory.openSession();
        
        Transaction tx = session.beginTransaction();        
        session.persist(student1);
        tx.commit();
        session.close();
    }
}
