package com.orm.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.orm.hibernate.entities.Certificate;
import com.orm.hibernate.entities.Student;

public class StatesDemo {
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		// Student object creation:: State: Transient:: Neither associated with DB nor Session
		Student student = new Student();
		student.setId(1021);
		student.setName("OPN");
		student.setCity("Tokyo");
		student.setCertificate(new Certificate("Java hibernate", "2 mths"));
		//--------------------------------------------------------------------------------------------
		
		Session session = sessionFactory.openSession();
		Transaction trxn = session.beginTransaction();
		
		// Student object saving:: State: Persistent:: Associated with DB & Session
		session.persist(student);
		
		// Student object updating:: State: Persistent:: Associated with DB & Session:
		// changes reflected in DB & Session
		student.setName("LMN");
		//--------------------------------------------------------------------------------------------
		
		trxn.commit();
		
		// Student object deleting:: State: Removed:: deleted from DB as well as from Session
		// To achieve this state, get() object from DB, perform remove().
		
		//--------------------------------------------------------------------------------------------
		
		// Student object detaching:: State: Detach:: Associated with DB only:: Removed from Session
		session.close();
		//--------------------------------------------------------------------------------------------
	}

}
