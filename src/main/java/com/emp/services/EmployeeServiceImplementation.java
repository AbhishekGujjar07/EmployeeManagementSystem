package com.emp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.entity.Employee;
import com.emp.repository.EmployeeRepo;

@Service
public class EmployeeServiceImplementation  {
	@Autowired
	EmployeeRepo repo;

	
	public void addEmployee(Employee e) {
		repo.save(e);
	}
	
	public List<Employee> getAllEmployee()
	{
		return repo.findAll();
	}
	
	public Employee getEmployeeById(int id)
	{
		 Optional<Employee> e=repo.findById(id);
		 if(e.isPresent())
		 {
			return e.get();
		 }
		 return null;
	}
	
	public void deleteEmployee(int id)
	{
		repo.deleteById(id);;
	}

}
