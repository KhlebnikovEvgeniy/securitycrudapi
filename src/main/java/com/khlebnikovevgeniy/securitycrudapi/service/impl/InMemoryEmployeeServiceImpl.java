package com.khlebnikovevgeniy.securitycrudapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.khlebnikovevgeniy.securitycrudapi.model.Employee;
import com.khlebnikovevgeniy.securitycrudapi.repository.InMemoryEmployeeRepository;
import com.khlebnikovevgeniy.securitycrudapi.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InMemoryEmployeeServiceImpl implements EmployeeService {
	
	private final InMemoryEmployeeRepository inMemoryEmployeeRepository;

	@Override
	public void addEmployee(Employee employee) {
		inMemoryEmployeeRepository.addEmployee(employee);	
	}

	@Override
	public List<Employee> getAllEmployees() {
		return inMemoryEmployeeRepository.getAllEmployees();
	}

	@Override
	public Employee findById(Integer id) {
		return inMemoryEmployeeRepository.findById(id);
	}

	@Override
	public void updateEmployee(Employee employee) {
		inMemoryEmployeeRepository.updateEmployee(employee);		
	}

	@Override
	public Boolean deleteById(Integer id) {
		return inMemoryEmployeeRepository.deleteById(id);
	}

}
