package com.springboot_hibernate.demo.service;

import java.util.List;

import com.springboot_hibernate.demo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee employee);
	
	public void delete(int theId);
}
