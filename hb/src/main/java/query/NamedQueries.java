package query;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;


public class NamedQueries {
    public static void main(String[] args) throws Exception  {
      Configuration c = new Configuration();
      c.configure("query/hibernate.cfg.xml");
      Session session = c.buildSessionFactory().openSession();

      List<Employee> employees = session.getNamedQuery("costlyEmployees")
    		                            .setParameter("salary",15000)
    		                            .list();
      for( Employee e : employees) {
            System.out.printf("%-20s %d\n",e.getName(),e.getSalary());
      }
    }
}
