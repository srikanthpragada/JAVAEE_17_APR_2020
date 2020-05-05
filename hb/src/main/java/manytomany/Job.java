package manytomany;

import java.util.HashSet;
import java.util.Set;

public class Job {
	private String id;
	private String title;
	
	private Set<Emp> employees = new HashSet<Emp>();
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Set<Emp> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Emp> employees) {
		this.employees = employees;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
