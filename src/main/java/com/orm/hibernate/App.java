package com.orm.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
        
        System.out.println(sessionFactory);
    }
}
