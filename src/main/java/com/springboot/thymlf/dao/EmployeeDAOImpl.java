package com.springboot.thymlf.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.thymlf.entity.Employee;

import jakarta.persistence.EntityManager;



@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	
	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Employee> theQuery = currentSession.createQuery("from Employee order by firstName",Employee.class);
		
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Employee theEmployee = currentSession.get(Employee.class,theId);
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
				
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.merge(theEmployee);
		
	}

	@Override
	public void deleteById(int theId) {
				
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId",null);
							
		theQuery.setParameter("employeeId",theId );
		
		theQuery.executeUpdate();
		
	}

}















