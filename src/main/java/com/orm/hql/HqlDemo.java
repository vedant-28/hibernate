package com.orm.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.orm.hibernate.entities.Student;

public class HqlDemo {
 
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		// Simple HQL query:: To perform SELECT operation 
		String query = "FROM Student";
		Query<Student> q1 = session.createQuery(query, Student.class);
		List<Student> students = q1.list();
		for(Student s : students) {
			System.out.println(s.getName());
		}
		
		// HQL query with WHERE
		String query2 = "FROM Student WHERE city='Tokyo'";
		Query<Student> q2 = session.createQuery(query2, Student.class);
		List<Student> list1 = q2.list();
		for(Student s : list1) {
			System.out.println(s.getName() + s.getCity());
		}
		
		// Dynamic params in HQL query
		String query3 = "FROM Student WHERE city=:value";
		Query<Student> q3 = session.createQuery(query3, Student.class);
		q3.setParameter("value", "Tokyo");
		List<Student> list2 = q2.list();
		for(Student s : list2) {
			System.out.println(s.getName() + s.getCity());
		}
		
		// HQL with table alias
		String query4 = "FROM Student AS s WHERE s.city=:x AND s.name=:n";
		Query<Student> q4 = session.createQuery(query4, Student.class);
		q4.setParameter("value", "Tokyo");
		q4.setParameter("value", "ABC");
		List<Student> list3 = q4.list();
		for(Student s : list3) {
			System.out.println(s.getName() + s.getCity());
		}
		
		// Complex HQL queries
		Transaction trxn = session.beginTransaction();
		
		// DELETE
		String query5 = "DELETE FROM Student AS s WHERE s.city=:c";
		Query<Student> q5 = session.createQuery(query5, Student.class);
		q5.setParameter("c", "Tokyo");
		int result = q5.executeUpdate();
		System.out.println(result + " row(s) affected...");
		
		// UPDATE
		String query6 = "UPDATE Student SET city=:c WHERE name=:n";
		Query<Student> q6 = session.createQuery(query6, Student.class);
		q6.setParameter("c", "Tokyo");
		q6.setParameter("n", "XYZ");
		int result1 = q6.executeUpdate();
		System.out.println(result1 + " row(s) affected...");
		
		// JOIN
		String query7 = "SELECT q.question, q.qid, a.answer FROM Question AS q INNER JOIN q.answer as a";
		Query<Object> q7 = session.createQuery(query7, Object.class);
		List<Object> objects = q7.getResultList();
		for(Object obj : objects) {
			System.out.println(obj);
		}
		
		trxn.commit();
		session.close();
	}
	
}
