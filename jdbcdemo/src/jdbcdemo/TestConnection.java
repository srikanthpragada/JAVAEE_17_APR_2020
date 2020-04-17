package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:derby:c:\\classroom\\derby\\hr");
		System.out.println("Connected To Derby Database!");
		con.close();
	}

}
