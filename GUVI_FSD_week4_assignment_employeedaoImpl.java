package com.guvi.Springboot_jdbctemplate.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.guvi.Springboot_jdbctemplate.pojo.EmployeePojo;


public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public EmployeeDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public EmployeeDaoImpl() {}

	@Override
	public List<EmployeePojo> getAllEmployees() {
		List<EmployeePojo> allEmployees = 
				jdbcTemplate.query("select * from employees", BeanPropertyRowMapper.newInstance(EmployeePojo.class));
		return allEmployees;
	}

	@Override
	public EmployeePojo getAEmployee(int empId) {
		List<EmployeePojo> getEmployee = 
				jdbcTemplate.query("select * from employees where emp_id =?", 
						BeanPropertyRowMapper.newInstance(EmployeePojo.class), empId);
		 if(getEmployee.isEmpty()) {
			 System.out.println("Employee is not Existed");
			 return null;
		 }
		return getEmployee.get(empId);
	}

	@Override
	public EmployeePojo addEmployee(EmployeePojo newEmployee) {
			 jdbcTemplate.update("insert into employees ( emp_id, emp_name , emp_salary ) values (?, ?, ?) ", 
					 newEmployee.getEmpId(), newEmployee.getEmpName(), newEmployee.getEmpSalary());
		return newEmployee;
	}

	@Override
	public EmployeePojo updateEmployee(EmployeePojo editEmployee) {
				 jdbcTemplate.update(" update employees set  emp_name=?, emp_salary=? where emp_id=? ", 
						 editEmployee.getEmpName(), editEmployee.getEmpSalary(), editEmployee.getEmpId());
			return editEmployee;
	}

	@Override
	public void deleteEmployee(int empId) {
		jdbcTemplate.update("delete from employees where emp_id=?", empId);
		
	}

}
