package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		
		Session session= factory.getCurrentSession();
		
		try {
			//use the session object to save Java object
			System.out.println("creating new student object...");
	
			//create 3 student object
			
			Student tempStudent1 = new Student("Burak","genc","burak@luv2code.com");
			Student tempStudent2 = new Student("Enes","cifci","enes@luv2code.com");
			Student tempStudent3 = new Student("Oguzhan","demir","oguzhan@luv2code.com");
			// start a transaction
			session.beginTransaction();
			//save the student project
			System.out.println("Saving the student");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("DONE!");
		} finally {
			factory.close();
		}
	}

}
