package com.springboot_jpa.demo.dao;


import java.util.List;

import com.springboot_jpa.demo.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> findAll();


public void deleteById(int theId);

public void save(Employee employee);

public Employee findById(int theId);
}