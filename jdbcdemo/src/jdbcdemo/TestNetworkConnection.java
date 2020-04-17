package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestNetworkConnection {

	public static void main(String[] args) throws Exception {
		// Class.forName("org.apache.derby.jdbc.ClientDriver");
		Connection con = DriverManager.getConnection("jdbc:derby://localhost/c:\\classroom\\derby\\hr");
		System.out.println("Connected To Derby Database!");
		con.close();
	}

}
