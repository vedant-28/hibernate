package com.orm.sql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.orm.hibernate.entities.Student;

public class NativeSqlDemo {
	
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		
		// Writing native MySQL query to fire on hibernate
		String query = "SELECT * FROM student";
	
		NativeQuery<Student> nativeQuery = session.createNativeQuery(query, Student.class);
		
		List<Student> resultList = nativeQuery.list();
		for(Student s : resultList) {
			System.out.println(s);
		}
		
		session.close();
		sf.close();
	}
	
}
