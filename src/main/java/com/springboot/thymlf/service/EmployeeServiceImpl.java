package com.springboot.thymlf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.thymlf.dao.EmployeeDAO;
import com.springboot.thymlf.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO  theEmployeeDAO;
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		
		return theEmployeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		
		return theEmployeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		
		theEmployeeDAO.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		
		theEmployeeDAO.deleteById(theId);

	}

}
