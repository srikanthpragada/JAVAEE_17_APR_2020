package onetomany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entities.Job;

public class DisplayDepartment {
	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure("onetomany/hibernate.cfg.xml");

		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		Department d =  s.get(Department.class, 60);
		System.out.println(d.getName());
		
		for (Emp e : d.getEmployees())
			System.out.println(e.getName());
		
		s.close();
		sf.close();
	}
}
