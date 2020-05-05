package onetoone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entities.Job;

public class AddEmployee {
	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure("onetoone/hibernate.cfg.xml");

		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Employee e = new Employee();
		e.setName("Larry Ellison");
		
		Membership m = new Membership();
		m.setType("N");
		e.setMembership(m);
		
	    s.save(e);
		t.commit();
		s.close();
		sf.close();
	}
}
