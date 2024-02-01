package org.springrest.staticfilteringapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springrest.staticfilteringapi.dto.EmployeeDTO;
import org.springrest.staticfilteringapi.entity.Employee;
import org.springrest.staticfilteringapi.service.EmployeeService;


@RestController
@RequestMapping("/employees")
public class EmployeeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired 
	private EmployeeService employeeService ;
	
	@GetMapping(value = "/all", produces = {"application/json","application/xml"})
	public ResponseEntity<List<EmployeeDTO>> fetchCustomers() {
		LOGGER.info("getting user data .....!");
		
	return ResponseEntity.status(HttpStatus.OK).body(employeeService.fetchCustomers())	;
		
	}
	
	@PostMapping(value = "/create", consumes = {"application/json","application/xml"})
	public ResponseEntity<EmployeeDTO> createCustomer(@RequestBody EmployeeDTO employeeDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createCustomer(employeeDTO));
	}
	
//	@PutMapping(value = "/update", consumes = {"application/json","application/xml"})
//	public ResponseEntity<EmployeeDTO> updateCustmer(@RequestBody EmployeeDTO employeeDTO) {
//		
//		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.updateCustmer(employeeDTO));;
//	}
	void deleteCustomer() {
		employeeService.deleteCustomer();
	}

}
