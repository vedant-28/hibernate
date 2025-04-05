package com.orm.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.orm.hibernate.entities.Student;

public class SecondCacheDemo {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		// Session no 1, queryinng entity with id=23
		Session session1 = sessionFactory.openSession();
		
		Student student = session1.get(Student.class, 23);
		System.out.println(student);
		
		session1.close();
		
		// Session no 2, queryinng entity with id=23
		Session session2 = sessionFactory.openSession();
		
		Student student2 = session2.get(Student.class, 23);
		System.out.println(student2);
		
		session2.close();
		
		sessionFactory.close();
		
	}

}
