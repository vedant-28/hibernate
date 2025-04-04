package com.orm.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.orm.hibernate.entities.Student;

public class CacheDemo {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		// First level cache: enabled by default
		Session session = sessionFactory.openSession();
		
		Student student = session.get(Student.class, 23);
		System.out.println(student);
		
		// Querying same object again
		// This object will be stored in session (1st level cache)
		// Hence when fetched 2nd time, DB query won't be fired
		Student student2 = session.get(Student.class, 23);
		System.out.println(student2);
		
		
		session.close();
		sessionFactory.close();
	}
	
}
