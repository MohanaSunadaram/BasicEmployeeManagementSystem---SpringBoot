package com.springboot.thymlf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.thymlf.entity.Employee;
import com.springboot.thymlf.service.EmployeeService;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService theEmployeeService;
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		List<Employee> theEmployees = theEmployeeService.findAll();
				
		theModel.addAttribute("employees",theEmployees);
		
		return "employees/list-employee";
	}
	
	@GetMapping("/showForm")
	public String showEmployeeFrom(Model theModel) {
		
		theModel.addAttribute("employee",new Employee());
		
		return "employees/employee-form";
		
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		theEmployeeService.save(theEmployee);
		
		return "redirect:/employees/list";
		
	}
	
	@GetMapping("/update")
	public String updateEmployee(@RequestParam("employeeId") int theId, Model theModel) {
		
		theModel.addAttribute("employee", theEmployeeService.findById(theId));
		
		return "employees/employee-form";		
		
	}
		
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int theId) {
		
		theEmployeeService.deleteById(theId);
		
		return "redirect:/employees/list";		
		
	}
	
}








