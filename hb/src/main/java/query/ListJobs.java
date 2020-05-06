package query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class ListJobs {

	public static void main(String[] args) {
		Configuration c = new Configuration();
		c.configure("query/hibernate.cfg.xml");
		Session session = c.buildSessionFactory().openSession();
         
		List<Job> jobs =  session.createQuery("from Job").list();
		for (Job j : jobs) {
			System.out.printf("%-30s  %d\n", j.getTitle(), j.getEmployees().size());
		}
		session.close();
	}
}
