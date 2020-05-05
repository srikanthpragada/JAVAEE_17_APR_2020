package manytomany;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ListJobs {
	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure("manytomany/hibernate.cfg.xml");

		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		List<Job> jobs = s.createQuery("from Job").getResultList();
		for (Job j : jobs)
		{
			System.out.println(j.getTitle());
			for(Emp e : j.getEmployees())
				System.out.println("*****" + e.getName());
		}
		
		s.close();
		sf.close();
	}
}
