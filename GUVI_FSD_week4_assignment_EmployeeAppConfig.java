package com.guvi.Springboot_jdbctemplate.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.guvi.Springboot_jdbctemplate.dao.EmployeeDao;
import com.guvi.Springboot_jdbctemplate.dao.EmployeeDaoImpl;

@Configuration
public class AppConfig {

	
	 @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource ds = new DriverManagerDataSource();
	        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
	        ds.setUrl("jdbc:mysql://localhost:3306/employee_management_sytem");
	        ds.setUsername("root");
	        ds.setPassword("Pass@123$$");
	        return ds;
	    }
	 
	    @Bean
	    public JdbcTemplate jdbcTemplate() {
	        return new JdbcTemplate(dataSource());
	    }
	 
	    @Bean(name = "employeeDao")
	    public EmployeeDao employeeDao() {
	        return new EmployeeDaoImpl(jdbcTemplate());
	    }
		 
}
	

