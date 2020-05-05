package manytomany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ListEmployees {
	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure("manytomany/hibernate.cfg.xml");

		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		Emp e =  s.get(Emp.class, 101);
		System.out.println(e.getName());
		for (Job j : e.getJobs())
			System.out.println(j.getTitle());
		s.close();
		sf.close();
	}
}
