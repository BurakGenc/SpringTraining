package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student tempStudent = new Student("Daffy","Duck","daffy@luv2code.com");
			
			// start a transaction
			session.beginTransaction();
			
			
			//save the student project
			System.out.println("Saving the student");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			
			//commit transaction
			session.getTransaction().commit();
			
			
			// MY NEW CODE
			//find out students's id:primary key
			System.out.println("Saved student. generated id: "+tempStudent.getId());
			
			//now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("\nGetting student with id "+ tempStudent.getId());
			Student myStudent=session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get complete: "+myStudent);
			
			session.getTransaction().commit();
			System.out.println("DONE!");
			
			//retrive student based the id : primary key
			
			//commit the transaction
			
			
			
			System.out.println("DONE!");
		} finally {
			factory.close();
		}
	}

}
	
