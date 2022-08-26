package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	/* 
	 * http://localhost:8080/employees?size=3&sort=name&page=1 
	 */
	@GetMapping
	public List<Employee> getAllEmployees(Pageable pageable) {
		return empService.findAllEmployees(pageable);
	}

	@GetMapping("/filter")
	public List<Employee> getEmployees(@RequestParam("pageSize") Integer pageSize,
			@RequestParam("pageNum") Integer pageNum, @RequestParam("sortBy") String sortBy) {
		return empService.findEmployees(pageSize, pageNum, sortBy);
	}

	/*
	 * http://localhost:8080/employees/query?pageSize=5&sortBy=name,id&pageNum=0&name=ch
	 */
	@GetMapping("/query")
	public List<Employee> getEmployeesByQuery(@RequestParam("pageSize") Integer pageSize,
			@RequestParam("pageNum") Integer pageNum, @RequestParam("sortBy") String sortBy,
			@RequestParam("name") String name) {
		return empService.findEmployeesByName(name, pageSize, pageNum, sortBy);
	}
}
