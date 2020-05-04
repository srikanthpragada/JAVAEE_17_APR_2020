package collections;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entities.Job;

public class AddCourse {
	public static void main(String[] args) throws Exception {
		Configuration cfg = new Configuration();
		cfg.configure("composition/hibernate.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Course c = new Course();
		c.setName("javaee");
		c.setDescription("Build Web Applications with Java EE");
		c.getTopics().add("JDBC");
		c.getTopics().add("Servlets");
		s.save(c);
		t.commit();
		s.close();
		sf.close();
	}
}
