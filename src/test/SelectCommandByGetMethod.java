package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class SelectCommandByGetMethod {

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

		// Persistent state
		Object obj=session.load(Student.class, 2);
		Student std= (Student)obj;
		System.out.println(std.getId());
		System.out.println(std.getName());
		System.out.println(std.getEmail());
		session.close();
		sessionFactory.close();
		System.out.println("Data select successfully....");
	}

}
