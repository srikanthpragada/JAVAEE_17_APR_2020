import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entities.Job;

public class AddJob { 

	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure();  // load hibernate.cfg.xml
		
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		
		Job job = new Job();
		job.setId("HB_PROG");
		job.setTitle("Hibernate Programmer");
		job.setMinSal(5000);
		job.setMaxSal(10000);
		
		Transaction trans = s.beginTransaction();
		s.save(job);  // Insert into JOBS table 
		System.out.println("Inserted!");
		trans.commit();
		System.out.println("Committed!");
		s.close();
		sf.close();
	}
}
