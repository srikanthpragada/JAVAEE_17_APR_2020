import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entities.Job;

public class DeleteJob {

	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure(); // load hibernate.cfg.xml

		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		Job job = s.get(Job.class, "HB_PROG");
		if (job == null)
			System.out.println("Sorry! Job id not found!");
		else {
			Transaction trans = s.beginTransaction();
            s.remove(job);
			trans.commit();
			System.out.println("Deleted!");
		}

		s.close();
		sf.close();
	}
}
