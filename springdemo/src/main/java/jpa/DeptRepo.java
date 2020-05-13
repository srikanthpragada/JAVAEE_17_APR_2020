package jpa;

import java.util.List; 

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DeptRepo extends CrudRepository<Department,Integer> {
   
	// Custom query using JPQL
	@Query("from Department d where d.id > ?1")   
	List<Department> getRecentDepartments(int deptid);
	
	// Native Query
	@Query(value="select avg(length(department_name)) from departments", nativeQuery=true)
	int  getAvgLength();
	
	// Query Derivation 
	List<Department> getDepartmentsByLocation (int locationid);
}
