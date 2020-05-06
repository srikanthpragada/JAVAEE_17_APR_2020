package query;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 

public class BulkUpdateDemo {
    public static void main(String[] args) {
      Configuration c = new Configuration();
      c.configure("query/hibernate.cfg.xml");
      Session session = c.buildSessionFactory().openSession();
      
      Transaction tx = session.beginTransaction();

      int count = session.createQuery
    		  ("update Employee set salary  = salary * 1.1 where salary < 1000").executeUpdate();
      System.out.println("No. of rows  updated :  " + count);
      tx.commit();
      session.close();
    } // main
 } // class
