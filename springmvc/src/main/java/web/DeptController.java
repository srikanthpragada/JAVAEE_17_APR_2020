package web;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Controller
public class DeptController {
	@Autowired
	private DeptRepo depts;

	@RequestMapping("/dept/{id}")
	public String getDept(@PathVariable("id") int id, ModelMap model) {
		Optional<Department> dept = depts.findById(id);
		String msg;
		if (dept.isPresent())
			msg = dept.get().getId() + " - " + dept.get().getName();
		else
			msg = "Sorry! Department Id not found!";

		model.addAttribute("message", msg);

		return "deptinfo";
	}

	@RequestMapping("/deptlist")
	public String getDeptList(ModelMap model) {
		model.addAttribute("depts", depts.findAll());
		return "deptlist";
	}
 
	@RequestMapping(value = "/departmentsxml", produces = { MediaType.APPLICATION_XML_VALUE } )
	@ResponseBody
	public String getDepartmentsXML() throws Exception {
		StringBuilder xml = new StringBuilder();
		xml.append("<Departments>");
		XmlMapper mapper = new XmlMapper();
		for (Department d :  depts.findAll())
		{
			xml.append(mapper.writeValueAsString(d));
		}
		xml.append("</Departments>");
		return xml.toString();
	} 
	 
	@RequestMapping(value = "/departments", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Iterable<Department> getDepartments() {
		return depts.findAll();
	}
	
	
	// Sends Department objects as XML 
	@RequestMapping(value = "/depts", 
		produces = {MediaType.APPLICATION_XML_VALUE}
	)
	@ResponseBody
	public Iterable<Department> getDeptXML() {
		return depts.findAll();
	}

	@RequestMapping("/departments/{name}")
	public String searchDeptList(@PathVariable("name") String name, ModelMap model) {
		model.addAttribute("depts", depts.findByNameContainingIgnoreCase(name));
		return "deptlist";
	}

	@RequestMapping("/adddept")
	public String addDept(ModelMap model) {
		Department d = new Department();
		model.addAttribute("dept", d);
		return "add_dept";
	}

	@RequestMapping(value = "/adddept", method = RequestMethod.POST)
	public String addDept(@Valid Department d, Errors errors, ModelMap model) {

		try {
			if (errors.getErrorCount() > 0) {
				String message = errors.getFieldErrors().get(0).getDefaultMessage();
				throw new RuntimeException(message);
			}

			if (depts.findById(d.getId()).isPresent())
				throw new RuntimeException("Dept id is already present!");

			depts.save(d);
			return "redirect:/deptlist";
		} catch (Exception ex) {
			model.addAttribute("dept", d);
			model.addAttribute("message", ex.getMessage());
			return "add_dept";
		}
	}

	@RequestMapping("/deletedept/{id}")
	public String deleteDept(@PathVariable("id") int id, ModelMap model) {
		Optional<Department> dept = depts.findById(id);
		if (dept.isPresent()) {
			depts.delete(dept.get());
			return "redirect:/deptlist";
		} else {
			model.addAttribute("error", "Department Id Not Found!");
			return "delete_dept";
		}
	}

	@RequestMapping("/editdept/{id}")
	public String editDept(@PathVariable("id") int id, ModelMap model) {
		Optional<Department> dept = depts.findById(id);
		if (dept.isPresent())
			model.addAttribute("dept", dept.get());
		else
			model.addAttribute("error", "Department Id Not Found!");

		return "edit_dept";
	}

	@RequestMapping(value = "/editdept/{id}", method = RequestMethod.POST)
	public String updateDept(@PathVariable("id") int id, Department d, ModelMap model) {
		try {
			Optional<Department> dept = depts.findById(d.getId());
			if (dept.isPresent())
				depts.save(d); // Update
			else
				throw new Exception("Invalid Department Id");
			return "redirect:/deptlist";
		} catch (Exception ex) {
			model.addAttribute("dept", d);
			model.addAttribute("error", ex.getMessage());
			return "edit_dept";
		}
	}
}
