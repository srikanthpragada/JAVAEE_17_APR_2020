package collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ListCourses {
	public static void main(String[] args) throws Exception {
		Configuration cfg = new Configuration();
		cfg.configure("collections/hibernate.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
	    List<Course> courses = s.createQuery("from Course").getResultList();
	    
	    for (Course c : courses)
	    {
	    	System.out.println(c.getName());
	    	System.out.println(c.getDescription());
	    	System.out.println("Topics : " +  String.join(",", c.getTopics()));
	    }
		s.close();
		sf.close();
	}
}
