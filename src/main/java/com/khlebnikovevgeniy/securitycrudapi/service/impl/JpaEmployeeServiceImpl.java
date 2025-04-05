package com.khlebnikovevgeniy.securitycrudapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.khlebnikovevgeniy.securitycrudapi.model.Employee;
import com.khlebnikovevgeniy.securitycrudapi.repository.JpaEmployeeRepository;
import com.khlebnikovevgeniy.securitycrudapi.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class JpaEmployeeServiceImpl implements EmployeeService  {
	
	private final JpaEmployeeRepository jpaEmployeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		return jpaEmployeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return jpaEmployeeRepository.findAll();
	}

	@Override
	public Employee findById(Integer id) {
		return jpaEmployeeRepository.findById(id).get();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee employeeForUpdate = findById(employee.getId());
		employeeForUpdate.setFirstName(employee.getFirstName());
		employeeForUpdate.setLastName(employee.getLastName());
		employeeForUpdate.setEmail(employee.getEmail());
		return jpaEmployeeRepository.save(employeeForUpdate);
	}

	@Override
	public Boolean deleteById(Integer id) {
		jpaEmployeeRepository.deleteById(id);
		return Boolean.TRUE;
	}

}
