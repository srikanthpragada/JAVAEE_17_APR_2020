package jpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
@SpringBootApplication
public class TestJPA implements CommandLineRunner {
	@Autowired
	DeptRepo repo; 

	public static void main(String[] args) {
		SpringApplication.run(TestJPA.class, args);
	}

	public void list() {
		for (Department d : repo.findAll())
			System.out.println(d.getName());
	}

	public void listByLocation(int id) {
		for (Department d : repo.getDepartmentsByLocation(id))
			System.out.println(d.getName());
	}
	
	public void listRecentDepartments(int id) {
		for (Department d : repo.getRecentDepartments(id))
			System.out.println(d.getName());
	}

	public void add(int id, String name,int location) {
		System.out.println(repo.getClass().getName());
		Department d = new Department();
		d.setId(id);
		d.setName(name);
		d.setLocation(location);
		repo.save(d);
		System.out.println("Department has been added successfully!");
	}

	public void updateDeptName(int id, String name) {
		Optional<Department> dept = repo.findById(id);
		if (dept.isPresent()) {
			Department d = dept.get();
			d.setName(name);
			repo.save(d);
		} else
			System.out.println("Department Id Not Found!");
	}

	public void run(String... args) {
		// list();
		// add(300,"Testing",1700);
		// updateDeptName(300, "QC");
		System.out.println("Avg. Length : " + repo.getAvgLength());
		// listByLocation(1700);
		// listRecentDepartments(200);
		
	}
}
