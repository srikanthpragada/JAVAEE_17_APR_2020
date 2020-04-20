import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListJobs {

	public static void main(String[] args) throws Exception {

		try (Connection con = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr")) {
			Statement st = con.createStatement();
			System.out.println(con.getClass());
			ResultSet rs = st.executeQuery("select job_title from jobs");
			
			while(rs.next()) {
				System.out.println( rs.getString("job_title"));  // rs.getString(1)
			}
			
			rs.close();
			st.close();
		}
	}

}
