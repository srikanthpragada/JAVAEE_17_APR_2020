package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

// @Controller
// @RequestMapping("/show")
public class ShowController {
	@RequestMapping("/session")
	@ResponseBody
	public String showName(@SessionAttribute("title") String title) {
		return title;
	}

	@RequestMapping("/cookie")
	@ResponseBody
	public String showLastAccess(@CookieValue("lastaccess") String lastAccess) {
		return lastAccess;

	}
}
