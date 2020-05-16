package web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeRepo empRepo;
	@Autowired
	private DeptRepo deptRepo;

	@RequestMapping("/employees")
	public String getEmployeesByDept(@RequestParam("id") int deptid, ModelMap model) {
		List<Employee> employees = empRepo.getEmployeesByDept(deptid);
		model.addAttribute("emps", employees);
		return "employees";
	}

	
	@RequestMapping("/empbydept")
	public String employeesByDept(ModelMap model) {
		Iterable<Department> departments = deptRepo.findAll();
		Department d = new Department();
		model.addAttribute("department",d);
		model.addAttribute("departments", departments );
		return "empByDept";
	}
	
	@RequestMapping(value = "/empbydept", method = RequestMethod.POST)
	public String employeesByDept(Department dept, ModelMap model) {
		Iterable<Department> departments = deptRepo.findAll();
		model.addAttribute("department",dept);
		model.addAttribute("departments", departments );
		// Get all employees by given department id
		model.addAttribute("employees",empRepo.getEmployeesByDept(dept.getId()));
		return "empByDept";
	}
}
