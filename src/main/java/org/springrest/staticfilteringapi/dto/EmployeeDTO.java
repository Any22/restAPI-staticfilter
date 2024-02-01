package org.springrest.staticfilteringapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
	 private Long id;
	 private String name;
	 
	 private String password;
	 private String email;
	 
	 
}
