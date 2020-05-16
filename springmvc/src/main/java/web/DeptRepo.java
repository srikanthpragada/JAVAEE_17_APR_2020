package web;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface DeptRepo extends CrudRepository<Department,Integer> {
   
	// Query Derivation
	List<Department> findByNameContainingIgnoreCase(String name);
}
