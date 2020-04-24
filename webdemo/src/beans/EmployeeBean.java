package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmployeeBean {
	private int empid;
	private int salary;
	private String message;

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	// Readonly property 
	public String getMessage() {
		return message;
	}

	// Returns number of rows updates - 0,1 or -1 for error
	public int updateSalary() {
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr")) {
			PreparedStatement ps = con.prepareStatement("update employees set salary = ? where employee_id = ?");
			ps.setInt(1, salary);
			ps.setInt(2, empid);
			int count = ps.executeUpdate();
			if (count == 1)
				message = "Updated Salary Successfully!";
			else
				message = "Employee Id Not Found!";
			ps.close();
			return count;
		} catch (Exception ex) {
			message = "Error :" + ex.getMessage();
			return -1;
		}
	}
}
