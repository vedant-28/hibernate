package com.orm.mappings;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		// Q1
		Question q1 = new Question();
		q1.setQ_id(1001);
		q1.setQuestion("What is Java?");
		
		// A1
		Answer a1 = new Answer();
		a1.setA_id(2001);
		a1.setAnswer("Programming language.");
		a1.setQuestion(q1);
		
		
		// A2
		Answer a2 = new Answer();
		a2.setA_id(2002);
		a2.setAnswer("Java is Object Oriented language.");
		a2.setQuestion(q1);
		
		// List of answers
		List<Answer> answers = new ArrayList<Answer>();
		answers.add(a1);
		answers.add(a2);
		
		// Adding list of answers to single question for @ManytoOne
		q1.setAnswers(answers);
		
		Session session = sessionFactory.openSession();
		Transaction trxn = session.beginTransaction();
		
		session.persist(q1);
		session.persist(a1);
		session.persist(a2);
		
		trxn.commit();
		session.close();
	}
	
}
