package org.springrest.staticfilteringapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springrest.staticfilteringapi.controller.EmployeeController;
import org.springrest.staticfilteringapi.dto.EmployeeDTO;
import org.springrest.staticfilteringapi.entity.Employee;
import org.springrest.staticfilteringapi.repository.EmployeeRepository;
@Service
public class EmployeeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
    private ModelMapper modelMapper;  
	
	@Autowired
	private EmployeeRepository employeeRepository ;
	
	public List<EmployeeDTO> fetchCustomers() {
		
		List<Employee> employees = employeeRepository.findAll();
		LOGGER.info("getting user data .....!"+ employees);
		List<EmployeeDTO> employeeDTOs = employees.stream()
										.map(emp -> modelMapper.map(emp, EmployeeDTO.class))
										.collect(Collectors.toList());
		return employeeDTOs;
	}
	
	public EmployeeDTO createCustomer(EmployeeDTO employeeDTO) {
		Employee employee = modelMapper.map(employeeDTO,Employee.class);
		employeeRepository.saveAndFlush(employee);
		return employeeDTO;
		
	}
	
	public void deleteCustomer() {
		
	}

//	public EmployeeDTO updateCustmer(EmployeeDTO employeeDTO) {
//		
//		return null;
//	}
}
