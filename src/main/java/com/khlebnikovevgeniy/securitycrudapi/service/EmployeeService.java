package com.khlebnikovevgeniy.securitycrudapi.service;

import java.util.List;

import com.khlebnikovevgeniy.securitycrudapi.model.Employee;

public interface EmployeeService {
	
	//Save an employee
	Employee addEmployee(Employee employee);
	
	//Get employees
	List<Employee> getAllEmployees();
	
	//Get one employee
	Employee findById(Integer id);
	
	//Update employee
	Employee updateEmployee(Employee employee);
	
	//Delete employee
	Boolean deleteById(Integer id);

}
