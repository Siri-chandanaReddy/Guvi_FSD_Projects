package com.guvi.Springboot_jdbctemplate;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.guvi.Springboot_jdbctemplate.configuration.AppConfig;
import com.guvi.Springboot_jdbctemplate.dao.EmployeeDao;
import com.guvi.Springboot_jdbctemplate.dao.EmployeeDaoImpl;
import com.guvi.Springboot_jdbctemplate.pojo.EmployeePojo;

@SpringBootApplication
public class SpringbootJdbctemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJdbctemplateApplication.class, args);
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeDao  employeeDAO = context.getBean("employeeDao", EmployeeDao.class);
		
        Scanner sc = new Scanner(System.in);
        
        int choice;
		
		do {
			System.out.println("***********************************");
			System.out.println("WELCOME TO EMPLOYEE MANAGEMENT SYSTEM");
			System.out.println("***********************************");
			System.out.println("1. Add an Employee");
			System.out.println("2. Fetch an Employee with an ID");
			System.out.println("3. Delete an Employee");
			System.out.println("4. Update an Employee");
			System.out.println("5. List all Employees");
			System.out.println("6. Exit");
			System.out.println("Enter your choice ? ");
			
			choice = sc.nextInt();
			sc.nextLine();
			
			System.out.println("***********************************");
			switch(choice) {
				case 1 -> 
				{
					System.out.println("Enter Employee Id :");
					int id = sc.nextInt();
					sc.nextLine();
	
					System.out.println("Enter Employee Name :");
					String name = sc.nextLine();
					
					System.out.println("Enter Employee Salary :");
					double salary = sc.nextDouble();
					 	
					EmployeePojo newEmp = new EmployeePojo (id,name,salary);
					
					employeeDAO.addEmployee(newEmp);
					System.out.println("***********************************");
					System.out.println("Employee with an ID: " + newEmp.getEmpId()+ " is added successfully!!");
					System.out.println("***********************************");
				}
				case 2 ->
				{
					System.out.println("***********************************");
					System.out.println("Enter the Employee ID of the Employee to be fetched: ");
					int searchId = sc.nextInt(); 
					EmployeePojo fetchedEmp= employeeDAO.getAEmployee(searchId);
//					if(fetchedEmp != null) {
//						System.out.println(fetchedEmp);
//					}else {
//						System.out.println("Sorry Employee with ID does not exist!!");
//					}
					System.out.println("***********************************");
				}
				case 3 ->
				{
					System.out.println("***********************************");
					System.out.println("Enter the Employee ID of the Employee to be removed: ");
					int deletdId = sc.nextInt();
					employeeDAO.deleteEmployee(deletdId);
					System.out.println("Employee removed sucessfully");
					
				}
				case 4 ->
				{
					System.out.println("Enter ID of an Employee to Update: ");
					int updatedId = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter new Name of Employee");
					String updatedName =sc.nextLine();
					System.out.println("Enter new Salary");
					double updatedsalary = sc.nextDouble();
					
					EmployeePojo updateEmp = new EmployeePojo(updatedId, updatedName, updatedsalary);
					employeeDAO.updateEmployee(updateEmp);
					System.out.println("Employee updated Sucessfully");
				}	
				case 5 ->
				{
					System.out.println("***********************************");
					List<EmployeePojo> allEmployees = employeeDAO.getAllEmployees();
					allEmployees.forEach((emp) -> System.out.println(emp));
					System.out.println("***********************************");
				}
				case 6 ->
				{
					System.out.println("***********************************");
					System.out.println("THANKYOU FOR USING EMPLOYEE MANAGEMENT SYSTEM");
					System.out.println("***********************************");
					System.exit(0);
				}
				default ->
					System.out.println("Please enter valid choice!!");
			}
			
		}while(choice != 6);
		
		System.out.println("***********************************");
		System.out.println("THANKYOU FOR USING EMPLOYEE MANAGEMENT SYSTEM");
		System.out.println("**************************************");
		context.close();
		sc.close();
	}

}
