package com.springboot.thymlf.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.thymlf.entity.Employee;
import com.springboot.thymlf.service.EmployeeService;

@RestController
@RequestMapping("api")
public class EmployeeRestController {

	@Autowired
	private EmployeeService theEmployeeService;

	@GetMapping("/employees")
	public List<Employee> findAll() {

		return theEmployeeService.findAll();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {

		Employee theEmployee = theEmployeeService.findById(employeeId);

		if (theEmployee == null) {
			throw new RuntimeException("Employee id not found " + employeeId);
		}

		return theEmployee;
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {

		theEmployeeService.save(theEmployee);

		return theEmployee;
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		theEmployeeService.save(theEmployee);
		return theEmployee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee theEmployee = theEmployeeService.findById(employeeId);
		
		if( theEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		theEmployeeService.deleteById(employeeId);
		
		return "Deleted employee id - "+ employeeId;
	}

}

















