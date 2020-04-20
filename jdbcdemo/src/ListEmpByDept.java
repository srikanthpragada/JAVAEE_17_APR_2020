// Update using PreparedStatement 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ListEmpByDept {

	public static void main(String[] args) throws Exception {

		Scanner s = new Scanner(System.in);

		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr")) {
			System.out.print("Enter Department Id :");
			int deptid = s.nextInt();

			PreparedStatement ps = con
					.prepareStatement("select first_name, salary from employees where department_id = ?");
			ps.setInt(1, deptid);

			ResultSet rs = ps.executeQuery();
			
			int total = 0;
			while(rs.next()) {
				System.out.printf("%-10s  %6d\n", rs.getString("first_name"), rs.getInt("salary"));
				total += rs.getInt("salary");
			}

			System.out.printf("\nTotal Salary = %d\n",total);
			
			rs.close();
			ps.close();
		}
	}

}
