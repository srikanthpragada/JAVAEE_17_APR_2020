package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ListJobs {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("oracle");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		List<Job> jobs = entityManager.createQuery("from JPAJob").getResultList();
		
		for(Job job : jobs)
			System.out.println(job.getTitle());

	}

}
