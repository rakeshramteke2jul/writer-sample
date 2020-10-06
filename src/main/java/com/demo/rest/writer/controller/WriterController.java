/*package com.demo.rest.writer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.rest.writer.dto.EmployeeDTO;
import com.demo.rest.writer.dto.RootDTO;
import com.demo.rest.writer.service.EmployeeService;
import com.synchrony.dataworks.dto.Employee;
import com.synchrony.dataworks.dto.services.EmployeeResponse;



@RestController
public class WriterController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	RestTemplate restTemplate;

	//final String ROOT_URI = "http://localhost:8080/api/employee";
	final String ROOT_URI ="http://dummy.restapiexample.com/api/v1/employees";
	final String USERNAME = "apiuser";
	final String PASSWORD ="welcometochatmeter";

	@GetMapping("/")
	public Integer load() {

		List<EmployeeDTO> employeeList = getAllEmployee();

		System.out.println("Size of the employee list :::" + employeeList);

		return employeeList.size();
	}

	private List<EmployeeDTO> getAllEmployee() {

		/*HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth(USERNAME, PASSWORD);
		headers.setContentType(MediaType.TEXT_HTML);
		HttpEntity<String> request = new HttpEntity<String>(headers);
		ResponseEntity<RootDTO> response = restTemplate.exchange(ROOT_URI, HttpMethod.GET, request,RootDTO.class);*/
		
		/*RootDTO response = restTemplate.getForObject(ROOT_URI, RootDTO.class);
		return response.getData();
	}
}*/
