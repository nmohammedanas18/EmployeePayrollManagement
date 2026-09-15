package com.payroll;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDAO {
	
	public void addEmployee(Employee employee)
	{
		String sql="insert into employees (name,email,phone,joining_date,department_id)  values (?,?,?,?,?)";
		
		try 
		{
			
			PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql); 
			
			statement.setString(1,employee.getName());
			statement.setString(2, employee.getEmail());
			statement.setString(3, employee.getPhone());
			statement.setDate(4,java.sql.Date.valueOf(employee.getJoiningDate()));
			statement.setInt(5,employee.getDepartment_id());
			
			
			statement.executeUpdate();
			
			System.out.println("Employee Added Successfully");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void getAllEmployees()
	{
		String sql="select employees.id,employees.name,employees.email, "+
				"employees.phone, employees.joining_date, departments.name as department_name " +
				"From employees " +
				"JOIN departments " +
				"ON employees.department_id=departments.id";
				
		
		try {
			PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
			
			var ResultSet = statement.executeQuery();
			
			System.out.println("ID | Name | Email | Phone | Joining Date | Department"); 
			
			while(ResultSet.next())
			{
				 System.out.println(ResultSet.getInt("id") + " | " +
					        ResultSet.getString("name") + " | " +
					        ResultSet.getString("email") + " | " +
					        ResultSet.getString("phone") + " | " +
					        ResultSet.getDate("joining_date") + " | " +
					        ResultSet.getString("department_name"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void getEmployeeById(int id)
	
	{
		String sql= "select * from  employees where id=?";
		try {
			PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
			statement.setInt(1, id);
			
			var  ResultSet = statement.executeQuery();
			
			if(ResultSet.next()) {
				System.out.println("ID: "+ResultSet.getInt("id"));
				System.out.println("Name : "+ResultSet.getString("name"));
				System.out.println("Email : "+ResultSet.getString("email"));
				System.out.println("Phone : "+ResultSet.getString("phone"));
				System.out.println("Joining Date : "+ResultSet.getDate("joining_date"));
				System.out.println("Department ID :" +ResultSet.getInt("department_id"));		
				
			}
			else
			{
				System.out.println("Employee Not Found ! ");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void  updateEmployeePhone(int id, String phone) {
		String sql = "update employees SET phone = ? where id = ?";
		
		try {
			PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
			
			statement.setString(1, phone);
			statement.setInt(2, id);
			
			int rows = statement.executeUpdate();
			
			if(rows>0) {
				System.out.println("phone number updated successfully");
			}
			else
			{
				System.out.println("Employee not found !");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void deleteEmployee(int id)
	{
		String sql = "Delete from employees where id = ?";
		
		try {
			PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
			statement.setInt(1, id);
			
			int rows = statement.executeUpdate();
			
			if (rows>0)
			{
				System.out.println("Employee Deleted Successfully");
			}
			else
			{
				System.out.println("Employee Not Found!");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
