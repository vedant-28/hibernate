package com.orm.mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		// Q1 & A1
		Question q1 = new Question();
		Answer a1 = new Answer();
		
		a1.setA_id(2001);
		a1.setAnswer("Java is programming language.");
		
		q1.setQ_id(1001);
		q1.setQuestion("What is Java?");
		q1.setA_id(a1);
		
		// Q2 & A2
		Question q2 = new Question();
		Answer a2 = new Answer();
		
		a2.setA_id(2002);
		a2.setAnswer("Set of APIs to work with data structures.");
		
		q2.setQ_id(1002);
		q2.setQuestion("What is Collection fwk?");
		q2.setA_id(a2);
		
		Session session = sessionFactory.openSession();
		Transaction trxn = session.beginTransaction();
		
		session.persist(q1);
		session.persist(q2);
		
		trxn.commit();
		session.close();
	}
	
}
