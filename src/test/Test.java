package test;

import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("resourses/hibernate.cfg.xml");
		configuration.buildSessionFactory();
	}

}
