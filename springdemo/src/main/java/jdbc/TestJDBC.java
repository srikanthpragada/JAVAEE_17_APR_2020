package jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestJDBC implements CommandLineRunner {
	@Autowired
	JobsManager jobs;
	public static void main(String[] args) {
		SpringApplication.run(TestJDBC.class, args);
	}

	public void run(String... args) {
		try {
			System.out.println("Updating salaries!");
			jobs.updateTwo(111, 412);
			System.out.println("Operation Completed!");
		} catch (Exception ex) {
			System.out.println("Operation Failed");
		}
	}

}
