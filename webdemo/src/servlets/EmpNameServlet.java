package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.CachedRowSet;
import com.google.gson.Gson;

import oracle.jdbc.rowset.OracleCachedRowSet;

@WebServlet("/ajax/empname")
public class EmpNameServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String empid = request.getParameter("empid");
		response.setContentType("text/plain");
		try {
			CachedRowSet crs = new OracleCachedRowSet();
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select first_name || ' ' || last_name fullname from employees where employee_id = ?");
			crs.setString(1, empid);
			crs.execute();
			String name = "";
			if (crs.next())
				name = crs.getString("fullname");
			crs.close();
			response.getWriter().print(name);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			response.getWriter().println("");
		}
	}

}
