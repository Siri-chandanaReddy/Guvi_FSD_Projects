package com.guvi.Springboot_jdbctemplate.dao;

import java.util.List;

import com.guvi.Springboot_jdbctemplate.pojo.EmployeePojo;

public interface EmployeeDao {

	List<EmployeePojo> getAllEmployees();
	EmployeePojo getAEmployee(int empId);
	EmployeePojo addEmployee(EmployeePojo newEmployee);
	EmployeePojo updateEmployee(EmployeePojo editEmployee);
	void deleteEmployee(int empId);
	
}
