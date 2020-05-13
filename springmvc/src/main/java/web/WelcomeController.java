package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {
	@RequestMapping("/welcome")
	@ResponseBody   // Specifies return string is response 
	public String welcome() {
		return "<h1>Welcome To Spring MVC</h1>";
	}
}
