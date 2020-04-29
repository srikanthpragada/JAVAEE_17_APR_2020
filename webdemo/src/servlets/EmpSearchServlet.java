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

@WebServlet("/ajax/empsearch")
public class EmpSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		response.setContentType("text/json");

		try {
			CachedRowSet crs = new OracleCachedRowSet();
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from employees where first_name like ?");
			crs.setString(1, "%" + name + "%");
			crs.execute();
			ArrayList<Employee> emps = new ArrayList<>();
			while (crs.next()) {
				emps.add(new Employee(crs.getString("first_name"), crs.getString("job_id"),
						crs.getString("department_id"), crs.getString("salary")));
			}
			crs.close();
			// Convert Java ArrayList of Employee objects to Json array of objects
			Gson gson = new Gson();
			response.getWriter().println(gson.toJson(emps));

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			response.getWriter().println("[]");
		}
	}

}
