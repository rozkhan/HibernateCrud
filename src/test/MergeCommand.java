package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class MergeCommand {

	public static void main(String[] args) {
		/*
		 * By this we can create table in database
		 * 
		 * Configuration configuration = new Configuration();
		 * configuration.configure("resourses/hibernate.cfg.xml"); // By this line we
		 * can perform DDL operation SessionFactory sessionFactory=
		 * configuration.buildSessionFactory(); sessionFactory.close();
		 * 
		 */

		Configuration configuration = new Configuration();
		configuration.configure("resourses/hibernate.cfg.xml");
		// By this line we can perform DDL operation
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		// Create student object
		
		session.get(Student.class, 1); 
		//If we perform get operation on same object then 
		//we can not use update method.Instead of we have to use merge method
		
		Student std = new Student();
		std.setId(1);
		std.setName("sam khan");
		//std.setEmail("akram@gmail.com");

		// Persistent state
		 session.update(std); 
		
		
		t.commit();  // data will execute here
		session.close();
		sessionFactory.close();
		System.out.println("Data Inserted successfully....");
	}

}
