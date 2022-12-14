package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		
		Session session= factory.getCurrentSession();
		
		try {
			//use the session object to save Java object
			System.out.println("creating new student object...");
	
			//create a student object
			Student tempStudent = new Student("Paul","Wall","paul@luv2code.com");
			// start a transaction
			session.beginTransaction();
			//save the student project
			System.out.println("Saving the student");
			session.save(tempStudent);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("DONE!");
		} finally {
			factory.close();
		}
	}

}
	
