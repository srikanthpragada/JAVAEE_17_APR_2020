package inh;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ListPersons {

	public static void main(String[] args) throws Exception {
       
		Configuration c = new Configuration();
		c.configure("inh/hibernate.cfg.xml");
		
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		
		Query q = s.createQuery("from Person"); // HQL

		for (Person p : (List<Person>) q.list()) {
			if (p instanceof Player)
			    System.out.println("Player  : " + p.getName());
			else
				System.out.println("Student : " + p.getName());
		}
		
		q = s.createQuery("from Player"); // HQL
		for (Player p : (List<Player>) q.list()) {
  	       System.out.println(p.getName()   +":" + p.getGame());
		}
		
				
		s.close();
		sf.close();
	}
}
