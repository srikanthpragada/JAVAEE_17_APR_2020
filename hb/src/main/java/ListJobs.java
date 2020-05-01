import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import entities.Job;

public class ListJobs { 

	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure();  // load hibernate.cfg.xml
		
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
        
		List<Job> jobs = s.createQuery("from Job").list(); 
        
		for(Job j : jobs) {
			System.out.printf("%-10s  - %s\n", j.getId(), j.getTitle());
		}
		s.close();
		sf.close();
	}
}
