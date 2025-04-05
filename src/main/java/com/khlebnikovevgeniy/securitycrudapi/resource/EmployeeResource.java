package com.khlebnikovevgeniy.securitycrudapi.resource;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khlebnikovevgeniy.securitycrudapi.model.Employee;
import com.khlebnikovevgeniy.securitycrudapi.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/employees")
public class EmployeeResource {
	private final EmployeeService employeeService;
	
	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees() {
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(employeeService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		employee.setId(employeeService.getAllEmployees().size() + 1);
		return ResponseEntity.created(getLocation(employee.getId())).body(employeeService.addEmployee(employee));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Boolean> deleteEmployee(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(employeeService.deleteById(id));
	}
	
	@PutMapping("/update/employee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok(employeeService.updateEmployee(employee));
	}
	
	private URI getLocation(Integer id) {
		return fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
	}
}
