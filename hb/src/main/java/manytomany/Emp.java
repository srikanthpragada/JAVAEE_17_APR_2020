package manytomany;

import java.util.HashSet;
import java.util.Set;

public class Emp {
	private int id;
	private String name;
    private Set<Job> jobs = new HashSet<>();

	public Set<Job> getJobs() {
		return jobs;
	}

	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
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

	 
}
