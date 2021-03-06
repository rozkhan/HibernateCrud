package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class SaveOrUpdate {

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

		Student std = new Student();
		std.setId(3);
		std.setName("Firoz khan");
		std.setEmail("firozaalam@gmail.com");

		// Persistent state
		 session.saveOrUpdate(std); 
		
		
		t.commit();  // data will execute here
		session.close();
		sessionFactory.close();
		System.out.println("Data Inserted successfully....");
	}

}
