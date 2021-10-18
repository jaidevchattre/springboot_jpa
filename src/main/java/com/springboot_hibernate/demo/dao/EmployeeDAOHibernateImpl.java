package com.springboot_hibernate.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot_hibernate.demo.entity.Employee;
@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	//define EntityManager
	private EntityManager entityManager;
	//set up Constructor Injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager em){
		entityManager=em;
	}
	
	@Override
	public List<Employee> findAll() {
		// get hibernate Session
		Session currentSession = entityManager.unwrap(Session.class);

		// query
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);

		// execute Query and get list
		List<Employee> employee = query.getResultList();

		return employee;
	}

	@Override
	public Employee findById(int theId) {
		// get current session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//get the employee
		Employee employee =currentSession.get(Employee.class,theId);
		return employee;
	}

	@Override
	public void save(Employee employee) {
		// get current session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//save or update the employee
		currentSession.saveOrUpdate(employee);
		
		
	}

	@Override
	public void deleteById(int theId) {
		//get current session
		Session currentSession= entityManager.unwrap(Session.class);
		
		Query query=currentSession.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId",theId);
		query.executeUpdate();
				
		
	}

}
