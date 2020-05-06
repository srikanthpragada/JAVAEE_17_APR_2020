package inh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddPersons {

	public static void main(String[] args) throws Exception {

		Configuration c = new Configuration();
		c.configure("inh/hibernate.cfg.xml");

		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();

		s.beginTransaction();

		Player p1 = new Player();
		p1.setName("Dhoni");
		p1.setGame("Cricket");

		Student s1 = new Student();
		s1.setName("Bill Gates");
		s1.setCourse("AI");

		s.save(p1);
		s.save(s1);

		s.getTransaction().commit();

		s.close();
		sf.close();
	}
}
