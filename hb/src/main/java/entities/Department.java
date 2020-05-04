package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="departments")
public class Department {

	private int id;
	private String name;

	@Id
	@Column(name = "department_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "department_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
