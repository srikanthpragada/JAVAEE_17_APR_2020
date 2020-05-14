package web;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

	// Query Derivation
	List<Employee> getEmployeesByDept(int id);

}
