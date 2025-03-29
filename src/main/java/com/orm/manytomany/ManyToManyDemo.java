package com.orm.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		// EMP1
		Employee e1 = new Employee();
		e1.setEid(101);
		e1.setName("ABC");
		
		
		// EMP2
		Employee e2 = new Employee();
		e2.setEid(102);
		e2.setName("PQR");
		
		
		// Project1
		Project p1 = new Project();
		p1.setPid(201);
		p1.setName("Insurance project");
		
		
		// Project2
		Project p2 = new Project();
		p2.setPid(202);
		p2.setName("Banking project");
		
		// List of emps
		List<Employee> employees = new ArrayList<Employee>();
		
		// List of projects
		List<Project> projects = new ArrayList<Project>();
		
		employees.add(e1);
		employees.add(e2);
		
		projects.add(p1);
		projects.add(p2);
		
		e1.setProjects(projects);
		p1.setEmployees(employees);
		
		Session session = sessionFactory.openSession();
		Transaction trxn = session.beginTransaction();
		
		session.persist(e1);
		session.persist(e2);
		session.persist(p1);
		session.persist(p2);
		
		trxn.commit();
		session.close();
	}

}
