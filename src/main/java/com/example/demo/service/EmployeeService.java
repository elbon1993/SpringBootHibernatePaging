package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.demo.model.Employee;

public interface EmployeeService {

	public List<Employee> findAllEmployees(Pageable pageable);

	public List<Employee> findEmployees(Integer pageSize, Integer pageNum, String sortBy);

	public List<Employee> findEmployeesByName(String name, Integer pageSize, Integer pageNum, String sortBy);
}
