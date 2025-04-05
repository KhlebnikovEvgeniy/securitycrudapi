package com.khlebnikovevgeniy.securitycrudapi.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.khlebnikovevgeniy.securitycrudapi.model.Employee;

@Repository
public class InMemoryEmployeeRepository {
	private static final List<Employee> DATABASE_EMPLOYEES = new ArrayList<>();
	
	static {
		DATABASE_EMPLOYEES.add(new Employee(1, "Damon", "Bayley", "damon@gmail.com"));
		DATABASE_EMPLOYEES.add(new Employee(2, "Marco", "Platt", "marco@gmail.com"));
		DATABASE_EMPLOYEES.add(new Employee(3, "Luke", "Bray", "luke@gmail.com"));
	}
	
	public void addEmployee(Employee employee) {
		DATABASE_EMPLOYEES.add(employee);
	};

	public List<Employee> getAllEmployees() {
		return List.copyOf(DATABASE_EMPLOYEES);
	};
	
	public Employee findById(Integer id) {
		return DATABASE_EMPLOYEES
				.stream()
				.filter(epm -> id.equals(epm.getId()))
				.findFirst()
				.orElseThrow();
	};
	
	public void updateEmployee(Employee employee) {
		Employee employeeForUpdate = findById(employee.getId());
		employeeForUpdate.setFirstName(employee.getFirstName());
		employeeForUpdate.setLastName(employee.getLastName());
		employeeForUpdate.setEmail(employee.getEmail());
		deleteById(employee.getId());
		addEmployee(employeeForUpdate);
	};
	
	public Boolean deleteById(Integer id) {
		Employee epmloyee = DATABASE_EMPLOYEES
				.stream()
				.filter(epm -> id.equals(epm.getId()))
				.findFirst()
				.orElseThrow();
		DATABASE_EMPLOYEES.remove(epmloyee);
		return Boolean.TRUE;
	};
}
