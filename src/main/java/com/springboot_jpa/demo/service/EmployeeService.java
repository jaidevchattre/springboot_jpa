package com.springboot_jpa.demo.service;

import java.util.List;

import com.springboot_jpa.demo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee employee);
	
	public void delete(int theId);
}
