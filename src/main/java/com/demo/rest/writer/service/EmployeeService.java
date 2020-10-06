package com.demo.rest.writer.service;

import java.util.List;

import com.demo.rest.writer.model.Employee;


public interface EmployeeService {
	
	public void write(List<? extends Employee> employees) throws Exception;

}
