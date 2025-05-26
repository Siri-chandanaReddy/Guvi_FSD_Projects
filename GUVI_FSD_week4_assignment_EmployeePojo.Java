package com.guvi.Springboot_jdbctemplate.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
//@Data

@AllArgsConstructor
@Setter
@Getter
@ToString

public class EmployeePojo {
	
	private int empId;
	private String empName;
	private double empSalary;
	
	
}
