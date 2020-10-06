package com.demo.rest.writer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.demo.rest.writer.dto.EmployeeDTO;
import com.demo.rest.writer.model.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
