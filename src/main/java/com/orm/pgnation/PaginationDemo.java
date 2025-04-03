package com.orm.pgnation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.orm.hibernate.entities.Student;

public class PaginationDemo {
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query<Student> query = session.createQuery("FROM Student", Student.class);
		
		//Pagination Impl:
		query.setFirstResult(0);
		query.setMaxResults(5);
		
		List<Student> resultList = query.getResultList();
		for(Student s : resultList) {
			System.out.println(s);
		}
		
		sessionFactory.close();
	}
}
