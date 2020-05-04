import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Department;

public class ListDepartments { 

	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure();  // load hibernate.cfg.xml
		c.addAnnotatedClass(entities.Department.class);
		
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
        
		List<Department> depts = s.createQuery("from Department").list(); 
        
		for(Department dept : depts) {
			System.out.printf("%d  - %s\n", dept.getId(), dept.getName());
		}
		s.close();
		sf.close();
	}
}
