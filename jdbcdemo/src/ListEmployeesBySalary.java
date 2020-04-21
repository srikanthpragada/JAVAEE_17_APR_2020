
// Using FilteredRowet
import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.RowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.Predicate;

import oracle.jdbc.rowset.OracleFilteredRowSet;

class SalaryPredicate implements Predicate {
	private int salary;

	public SalaryPredicate(int salary) {
		this.salary = salary;
	}

	@Override
	public boolean evaluate(RowSet rs) {
		try {
			return rs.getInt("salary") > this.salary;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean evaluate(Object arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean evaluate(Object arg0, String arg1) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
}

public class ListEmployeesBySalary {

	public static void main(String[] args) throws Exception {

		try (FilteredRowSet frs = new OracleFilteredRowSet()) {
			frs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			frs.setUsername("hr");
			frs.setPassword("hr");
			frs.setCommand("select * from employees");
			frs.execute();

			Scanner s = new Scanner(System.in);

			while (true) {
				System.out.println("Enter min salary [0 to stop] : ");
				int salary = s.nextInt();
				if (salary == 0)
					break;

				frs.setFilter(new SalaryPredicate(salary)); // Predicate interface 
				
				frs.beforeFirst();
				while (frs.next()) {
					System.out.printf("%-10s  %6d\n", frs.getString("first_name"), frs.getInt("salary"));
				}
			}
		}
	}
}
