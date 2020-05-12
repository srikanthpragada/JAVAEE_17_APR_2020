package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Component
public class JobsManager implements CommandLineRunner {
	
	@Autowired
	SJIDemo sjiDemo;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	
	public void showAverageSalary() {
		Double avgSalary = jdbcTemplate.queryForObject
				 ("select round(avg(salary)) from employees", Double.class);
		System.out.println("Avgerage salary  = " + avgSalary);
	}
	
	public void showJobCount() {
		Integer count = jdbcTemplate.queryForObject("select count(*) from jobs", Integer.class);
		System.out.println("Count = " + count);
	}

	public void listJobsWith7() {
		List<Job> jobs = jdbcTemplate.query("select * from jobs", 
			new RowMapper<Job>() {
		    	@Override
			    public Job mapRow(ResultSet rs, int rowNum) throws SQLException {
				    return  new Job(rs.getString("job_id"),rs.getString("job_title"));
			    }
		    });

		for (Job j : jobs)
			System.out.println(j.getTitle());
	}

	public void listJobsWithLambda() {
		List<Job> jobs = jdbcTemplate.query("select * from jobs",
				// RowMapper (mapRow()) is implemented using Lambda Expression
				(rs, rowNum) -> new Job(rs.getString("job_id"), rs.getString("job_title")));

		for (Job j : jobs)
			System.out.printf("%-10s  %s\n",j.getId(), j.getTitle());
	}

	public void listJobTitles() {
		List<String> titles = jdbcTemplate.query("select job_title from jobs",
				// RowMapper is implemented using Lambda Expression
				(rs, rowNum) -> rs.getString("job_title"));

		for (String title : titles)
			System.out.println(title);
	}

	public void listJobTitlesWithJava7() {
		List<String> titles = jdbcTemplate.query("select job_title from jobs",
	     // Anonymous inner class to implement RowMapper		
		 new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNum) {
				try {
					return rs.getString("job_title");
				} catch (Exception ex) {
					return null;
				}
			}
		});

		for (String title : titles)
			System.out.println(title);
	}

	public void updateMinSalary() {
		int count = jdbcTemplate.update
				("update jobs set min_salary = ? where job_id = ?", 5000, "IT_PROG");
		System.out.println("No. of rows updated : " + count);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void updateTwo(int e1, int e2) {
		TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
		System.out.println("Transaction Begins");

		int count = jdbcTemplate.update("update employees set salary = salary + 1000 where employee_id = ?", e1);
		if (count == 0) {
			// throw new RuntimeException();
			status.setRollbackOnly();
			return;
		}

		System.out.println("First Update Done");

		count = jdbcTemplate.update("update employees set salary = salary + 2000 where employee_id = ?", e2);
		if (count == 0)
			status.setRollbackOnly();
		else
			System.out.println("Second update done!");
		
		
		System.out.println("New Transaction : " + status.isNewTransaction());
		System.out.println("Rollback ? " + status.isRollbackOnly());
		System.out.println("Function Done!");
	}

	public void run(String... args) {
		// showAverageSalary();
		// showJobCount();
		// listJobsWithLambda();
		// listJobs2();
		// listJobTitles();
		// listJobTitlesWithJava7();
		// updateMinSalary();
		// sjiDemo.add();
	}

}
