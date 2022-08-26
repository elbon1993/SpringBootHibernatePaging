package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository empRepository;
	
	@Override
	public List<Employee> findAllEmployees(Pageable pageable) {
		Page<Employee> list = empRepository.findAll(pageable);
		if(list.hasContent()) {
			return list.getContent();
		} else {
			return Arrays.asList();
		}
	}

	@Override
	public List<Employee> findEmployees(Integer pageSize, Integer pageNum, String sortBy) {
		Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by(sortBy));
		Page<Employee> list = empRepository.findAll(pageable);
		if(list.hasContent()) {
			return list.getContent();
		} else {
			return Arrays.asList();
		}
	}

	@Override
	public List<Employee> findEmployeesByName(String name, Integer pageSize, Integer pageNum, String sortBy) {
//		Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by(name));
//		Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by(name.split(",")).ascending());
		Pageable pageable = PageRequest.of(pageNum, pageSize, 
				Sort.by(sortBy.split(",")[0].split(" ")).descending()
				.and(Sort.by(sortBy.split(",")[1].split(" ")).ascending()));
		Page<Employee> list = empRepository.findEmployeesByName(name, pageable);
		if(list.hasContent()) {
			return list.getContent();
		} else {
			return Arrays.asList();
		}
	}

}
