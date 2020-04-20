// Update using PreparedStatement 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateSalary3 {

	public static void main(String[] args) throws Exception {

		Scanner s = new Scanner(System.in);

		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr")) {
			System.out.print("Enter Employee Id :");
			int empid = s.nextInt();
			System.out.print("Enter new salary  :");
			int salary = s.nextInt();

			PreparedStatement ps = con.prepareStatement
					  ("update employees set salary = ? where employee_id = ?");
			ps.setInt(1, salary);
			ps.setInt(2, empid);
			
			int count = ps.executeUpdate();

			if (count == 1)
				System.out.println("Updated Salary Successfully!");
			else
				System.out.println("Employee Id Not Found!");

			ps.close();
		}
	}

}
