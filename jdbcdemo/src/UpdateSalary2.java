// Update using concatenation and Statement 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateSalary2 {

	public static void main(String[] args) throws Exception {

		Scanner  s= new Scanner(System.in);

		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr")) {
			System.out.print("Enter Employee Id :");
			int empid = s.nextInt();
			System.out.print("Enter new salary  :");
			int salary = s.nextInt();
			
			Statement st = con.createStatement();
			String cmd = "update employees set salary = " + salary + " where employee_id = " + empid;
			System.out.println(cmd);
			int count = st.executeUpdate(cmd);
			
			if (count == 1)
				System.out.println("Updated Salary Successfully!");
			else
				System.out.println("Employee Id Not Found!");

			st.close();
		}
	}

}
