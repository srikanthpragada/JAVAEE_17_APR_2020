package web;

import java.time.LocalDateTime;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// @Controller
public class StateController {
	@RequestMapping("/state")
	@ResponseBody
	public String stateDemo(HttpServletRequest req,
			HttpServletResponse resp, HttpSession s) {
		resp.setContentType("text/html");
		String st = "";
		for (Cookie c : req.getCookies())
			st += c.getName() + " - " + c.getValue() + "<p/>";

		
		// Create session/browser based cookie 
		Cookie c = new Cookie("lastaccess", 
				LocalDateTime.now().toString());
		resp.addCookie(c);
		
		// Session attribute
		s.setAttribute("title", "Demo Application");
		
		ServletContext ctx = s.getServletContext();
		s.setAttribute("name", this.getClass().getName());
		
		return st;
	}
}
