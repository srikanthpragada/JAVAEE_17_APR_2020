package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeRepo emps;

	@RequestMapping("/employees")
	public String getEmployeesByDept(@RequestParam("id") int deptid, ModelMap model) {
		model.addAttribute("emps", emps.getEmployeesByDept(deptid));
		return "employees";
	}
}
