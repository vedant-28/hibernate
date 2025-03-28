package com.orm.hibernate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.orm.hibernate.entities.Address;
import com.orm.hibernate.entities.Certificate;
import com.orm.hibernate.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project started..." );
        
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();   
        
        // new Student creation
        Student student1 = new Student();
        Certificate certificate1 = new Certificate();
        
        certificate1.setCourse("Java");
        certificate1.setDuration("6 mths");
        
        student1.setId(1001);
        student1.setName("ABC");
        student1.setCity("Tokyo");
        student1.setCertificate(certificate1);
        
        System.out.println(student1);
        
        
        // Create new address
        Address address1 = new Address();
        address1.setStreet("8th street");
        address1.setCity("Tokyo");
        address1.setAddedDate(new Date());
        address1.setOpen(true);
        address1.setX(1234);
        // Reading image
		FileInputStream fis = new FileInputStream("src/main/java/image.jpg");
		byte[] imageData = new byte[fis.available()];
		address1.setImage(imageData);
        
        Session session = sessionFactory.openSession();
        
        Transaction tx = session.beginTransaction();        
        session.persist(student1);
        session.persist(address1);
        
        
        
        // @Embeddable demo
        System.out.println("Embeddable demo start...");
        Student student2 = new Student();
        Certificate certificate2 = new Certificate();
        
        certificate2.setCourse("Spring fwk");
        certificate2.setDuration("6 mths");
        
        student2.setId(1002);
        student2.setName("PQR");
        student2.setCity("Tokyo");
        student2.setCertificate(certificate2);
        
        session.persist(student2);
        System.out.println("Embeddable demo finish...");
        
        tx.commit();
        session.close();
    }
}
