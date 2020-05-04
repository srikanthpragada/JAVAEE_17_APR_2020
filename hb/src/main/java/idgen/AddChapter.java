package idgen;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entities.Job;

public class AddChapter {
	public static void main(String[] args) throws Exception {
		Configuration cfg = new Configuration();
		cfg.configure("idgen/hibernate.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Chapter c= new Chapter();
		ChapterID id = new ChapterID(1,2);
	    c.setId(id);
	    c.setTitle("First Program");
		s.save(c);
	
		t.commit();
		s.close();
		sf.close();
	}
}
