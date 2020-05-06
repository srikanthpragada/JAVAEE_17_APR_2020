package query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class ListEmployees {

	public static void main(String[] args) {
		Configuration c = new Configuration();
		c.configure("query/hibernate.cfg.xml");
		Session session = c.buildSessionFactory().openSession();
        // Fetch job to avoid N+1 problem          
		List<Employee> employees =  session.createQuery("from Employee e join fetch e.job").list();
		// List<Employee> employees =  session.createQuery("from Employee").list();
		for (Employee e : employees) {
			System.out.printf("%-30s  %-20s  %d\n", e.getName(),
					            e.getJob().getTitle(), e.getSalary());
		}
		session.close();
	}
}
