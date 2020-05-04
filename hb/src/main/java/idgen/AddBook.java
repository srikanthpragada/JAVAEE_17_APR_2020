package idgen;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entities.Job;

public class AddBook {
	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure("idgen/hibernate.cfg.xml");

		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Book b = new Book();
		b.setTitle("Book1");
		s.save(b);
		t.commit();
		s.close();
		sf.close();
	}
}
