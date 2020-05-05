package onetoone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entities.Job;

public class ListEmployees {
	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure("onetoone/hibernate.cfg.xml");

		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		Employee e =  s.get(Employee.class, 1);
		System.out.println(e.getName());
		Membership m = e.getMembership();
		System.out.println(m.getType());
		s.close();
		sf.close();
	}
}
