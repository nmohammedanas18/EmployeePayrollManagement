package com.payroll;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		
		
		Scanner scanner = new Scanner(System.in);
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
	    PayrollDAO payrollDAO = new PayrollDAO();
		
		
		
		while(true)
		{
			System.out.println("\n=== EMPLOYEE PAYROLL MANAGEMENT =====");
			System.out.println("1.Add Employee");
			System.out.println("2.View Employee");
			System.out.println("3.Search Employee");
			System.out.println("4.Update Employee");
			System.out.println("5.Delete Employee");
			System.out.println("6.Add Payroll");
			System.out.println("7.View Payroll");
			System.out.println("8.Payroll Report");
			System.out.println("9.Exit");
			
			System.out.println("Enter Your choice : ");
			
			int choice = scanner.nextInt();
			
			 if (choice == 1)
			{
				System.out.println("Enter Employee Name : ");
				String name = scanner.next();
				
				System.out.println("Enter Your Email : ");
				String email = scanner.next();
				
				
				System.out.println("Enter Your Phone : ");
				String phone = scanner.next();
				
				System.out.println("Enter Joining Year : ");
				int year = scanner.nextInt();
				
				System.out.println("Enter Joining Month : ");
				int month = scanner.nextInt();
				
				System.out.println("Enter Joining Day : ");
				int day = scanner.nextInt();
				
				System.out.println("Enter Department ID : ");
				int departmentId = scanner.nextInt();
				
				LocalDate joiningDate = LocalDate.of(year, month, day);
				
				Employee employee = new Employee(name,email,phone,joiningDate,departmentId);
				
				employeeDAO.addEmployee(employee);
				
			}
			
			else if (choice == 2) {
			    employeeDAO.getAllEmployees();
			}
			
			else if (choice == 3) {
				System.out.println("Enter Employee ID : ");
				int id = scanner.nextInt();
				employeeDAO.getEmployeeById(id);
			}
			
			else if (choice == 4) {
				System.out.println("Enter Employee ID : ");
				int id=scanner.nextInt();
				
				System.out.println("Enter new Phone number : ");
				String phone =scanner.next();
				
				employeeDAO.updateEmployeePhone(id,phone);
			}
			
			else if (choice == 5)
			{
				System.out.println("Enter Employee ID : ");
				int id = scanner.nextInt();
				
				employeeDAO.deleteEmployee(id);
				
			}
			
			
			
			else if (choice == 6)
			{
				System.out.println("Enter Employee ID : ");
				int employeeId = scanner.nextInt();
				
				System.out.println("Enter basic salary : ");
				double basic = scanner.nextDouble();
				
				System.out.println("Enter HRA : ");
				double hra = scanner.nextDouble();
				
				System.out.println("Enter transport allowance : ");
				double ta = scanner.nextDouble();
				
				System.out.println("Enter medical allowance : ");
				double medicalAllowance = scanner.nextDouble();
				
				System.out.println("Enter special allowance : ");
				double specialAllowance = scanner.nextDouble();
				
				System.out.println("Enter PF : ");
				double pf = scanner.nextDouble();
				
				System.out.println("Enter ESIC : ");
				double esic = scanner.nextDouble();
				
				System.out.println("Enter professional Tax : ");
				double professionalTax = scanner.nextDouble();
				
				Payroll payroll = new Payroll(employeeId,basic,hra,ta,medicalAllowance,specialAllowance,pf,esic,professionalTax);
				
				payroll.calculatePayroll();
				
				payrollDAO.addPayroll(payroll);
			}
				
			else if(choice == 7) {
				payrollDAO.getAllPayroll();
			}
			
			else if(choice == 8) {
					
				payrollDAO.getPayrollReport();
			}
			
			if (choice == 9) {
			    System.out.println("Application closed.");
			    break;
			}
			
			else {
			    System.out.println("Invalid choice! Please enter 1 to 9.");
			}
			System.out.println("You Selected Option : " + choice);
		}
		
		
		
}


}
