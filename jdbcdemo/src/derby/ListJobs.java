package derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListJobs {

	public static void main(String[] args) throws Exception {
		// Connection con = DriverManager.getConnection("jdbc:derby:c:\\classroom\\derby\\hr");
		Connection con = DriverManager.getConnection("jdbc:derby://localhost/c:\\classroom\\derby\\hr");
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery("select * from jobs");

		while (rs.next()) {
			System.out.println(rs.getString("title"));
		}

		rs.close();
		st.close();
		con.close();
	}

}
