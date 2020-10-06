package com.demo.rest.writer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.rest.writer.model.Employee;
import com.demo.rest.writer.repository.EmployeeRepository;
import com.demo.rest.writer.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public void write(List<? extends Employee> employees) throws Exception {
		// TODO Auto-generated method stub
		
	}

/*	@Autowired
	private EmployeeRepository empRepository;

	@Override
	public void write(List<? extends Employee> employees) throws Exception {

		System.out.println("Data Saved for Users: " + employees);
		empRepository.saveAll(employees);
	}*/

}
