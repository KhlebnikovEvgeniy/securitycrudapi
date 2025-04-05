package com.khlebnikovevgeniy.securitycrudapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khlebnikovevgeniy.securitycrudapi.model.Employee;

@Repository
public interface JpaEmployeeRepository extends JpaRepository<Employee, Integer> {

}
