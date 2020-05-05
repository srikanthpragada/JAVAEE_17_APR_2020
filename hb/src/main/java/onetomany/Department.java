package onetomany;

import java.util.HashSet;
import java.util.Set;

public class Department {
	private int id;
	private String name;
	private Set<Emp> employees = new HashSet<Emp>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Emp> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Emp> employees) {
		this.employees = employees;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
