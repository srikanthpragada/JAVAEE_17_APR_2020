package web;

import java.time.LocalDateTime;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StateController {
	@RequestMapping("/cookies")
	@ResponseBody
	public String useCookies(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html");
		String st = "";
		for (Cookie c : request.getCookies())
			st += c.getName() + " - " + c.getValue() + "<p></p>";

		
		// Create session/browser based cookie 
		Cookie c = new Cookie("lastaccess", LocalDateTime.now().toString());
		// c.setMaxAge(24 * 60 * 60);
		response.addCookie(c);
		
		return st;
	}
	
	@RequestMapping("/session")
	@ResponseBody 
	public String useSession(HttpSession session) {
		// Session attribute
		session.setAttribute("title", "Demo Application");
		
		ServletContext ctx = session.getServletContext();
		session.setAttribute("name", this.getClass().getName());
		
		return "<h2>Session Attribute Created!</h2>";
	}
	
	@RequestMapping("/lastaccess")
	@ResponseBody 
	public String lastAccess(@CookieValue("lastaccess") Cookie time) {
		return "<h2>" + time.getValue()+ "</h2>";
	}
}
