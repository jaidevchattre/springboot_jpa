package com.springboot_hibernate.demo.rest;

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

import com.springboot_hibernate.demo.entity.Employee;
import com.springboot_hibernate.demo.service.EmployeeService;




@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService empService) {
		employeeService=empService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee findById(@PathVariable int employeeId) {
		Employee emp= employeeService.findById(employeeId);
		
		if(emp == null) {
			throw new RuntimeException("Employee id not found");
		}
		return emp;
	}
	
	@PostMapping("/employees")
	public Employee save(@RequestBody Employee emp) {
		employeeService.save(emp);
		return emp;
	}
	
	@PutMapping("/employees")
	public Employee update(@RequestBody Employee emp) {
		employeeService.save(emp);
		return emp;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee  emp=employeeService.findById(employeeId);
		if(emp==null) {
			return "No employee exist with id"+employeeId;
		}
		employeeService.delete(employeeId);
		
		return "Deleted employee id is ";
		
	}
	
	
	

}
