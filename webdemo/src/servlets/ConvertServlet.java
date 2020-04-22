package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/convert")
public class ConvertServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		double inches = Double.parseDouble(request.getParameter("inches"));
		double cm = inches * 2.5;
		PrintWriter pw = response.getWriter();
		pw.printf("<h1>%.2f inches = %.2f CM </h1>", inches, cm);
	}
}
