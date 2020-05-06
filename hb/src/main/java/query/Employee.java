package query;

import java.util.HashSet;
import java.util.Set;

public class Employee {
	private int id;
	private String name;
	private int salary;
	private Job job;

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return id + "," + name + ", " + salary + "," + job.toString();
	}

}
