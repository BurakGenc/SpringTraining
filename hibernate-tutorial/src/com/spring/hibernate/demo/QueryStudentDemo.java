package com.spring.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Student;

public class QueryStudentDemo {

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
	
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			displayStudents(theStudents);

			// query students: lastName='Doe'
			theStudents = session.createQuery("from Student s where s.lastName='demir'").getResultList();
			System.out.println("\n\nStudents who have last name of demir");
			displayStudents(theStudents);
			
			
			
			// query students: lastName='demir' OR firstName='enes'
			theStudents = session.createQuery("from Student s where s.lastName='demir' OR s.firstName='enes'").getResultList();
			System.out.println("\n\nStudents who have last name of Doe OR first name Daffy");
			displayStudents(theStudents);
			
			// query students where email LIKE '%gmail.com'
			theStudents = session.createQuery("from Student s where s.email LIKE '%luv2code.com'").getResultList();
			System.out.println("\n\nStudents whose email ends with gmail.com");			
			displayStudents(theStudents);
						
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("DONE!");
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student student : theStudents) {
			System.out.println(student);
			
		}
	}

}
	
