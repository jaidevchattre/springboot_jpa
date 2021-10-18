package com.springboot_jpa.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot_jpa.demo.entity.Employee;
@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {
	//define EntityManager
	private EntityManager entityManager;
	//set up Constructor Injection
	@Autowired
	public EmployeeDAOJPAImpl(EntityManager em){
		entityManager=em;
	}
	
	@Override
	public List<Employee> findAll() {
    //Create a query
		Query theQuery=entityManager.createQuery("from Employee");
		
	//Execute the query and get result list
		List<Employee> employees=theQuery.getResultList();
		return  employees;
	}

	@Override
	public Employee findById(int theId) {
		// get employee by id
		Employee employee=entityManager.find(Employee.class, theId);
		return employee;
	}

	@Override
	public void save(Employee employee) {
     
		//save or update the employee
		Employee dbEmployee= entityManager.merge(employee);
		
		//update the id from db
		employee.setId(dbEmployee.getId());
		
	}

	@Override
	public void deleteById(int theId) {

		// delete object with primary key
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");

		theQuery.setParameter("employeeId", theId);

		theQuery.executeUpdate();
	}

}
