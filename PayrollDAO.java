package com.payroll;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PayrollDAO {
	
	public void addPayroll(Payroll payroll) {
		
		String sql="insert into payroll " +
		"(employee_id,basic,hra,ta,medical_allowance,special_allowance," +
				"pf,esic,professional_tax, total_earnings, total_deductions, net_pay )" +
		"values (?,?,?,?,?,?,?,?,?,?,?,?)";
		
		
		try {
			PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
			
			statement.setInt(1,payroll.getEmployeeId());
			statement.setDouble(2, payroll.getBasic());
			statement.setDouble(3,payroll.getHra());
			statement.setDouble(4,payroll.getTa());
			statement.setDouble(5,payroll.getMedicalAllowance());
			statement.setDouble(6,payroll.getSpecialAllowance());
			statement.setDouble(7,payroll.getPf());
			statement.setDouble(8,payroll.getEsic());
			statement.setDouble(9,payroll.getProfessionalTax());
			statement.setDouble(10,payroll.getTotalEarnings());
			statement.setDouble(11,payroll.getTotalDeductions());
			statement.setDouble(12,payroll.getNetPay());
			
			statement.executeUpdate();
			
			System.out.println("Payoll Added Successfully");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getAllPayroll()
	{
		String sql = "SELECT employees.id AS employee_ID, employees.name AS employee_name, payroll.basic, payroll.hra, payroll.ta,"
				+ " payroll.medical_allowance, payroll.special_allowance, payroll.pf, payroll.esic,"
				+ " payroll.professional_tax, payroll.total_earnings, payroll.total_deductions, payroll.net_pay "
				+ "FROM payroll JOIN employees ON payroll.employee_id = employees.id";

			try {
				PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
				var ResultSet = statement.executeQuery();
				
				System.out.println("ID | Employee Name | Total Earnings | Total Deductions | Net Pay");
				
				  while (ResultSet.next()) {

			            System.out.println(
			                ResultSet.getInt("employee_id") + " | " +
			                ResultSet.getString("employee_name") + " | " +
			                ResultSet.getDouble("total_earnings") + " | " +
			                ResultSet.getDouble("total_deductions") + " | " +
			                ResultSet.getDouble("net_pay")
			            );
			        }
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
						
	}
	
		public void getPayrollReport()
		{
			String sql = "SELECT employees.id AS employee_id, employees.name AS employee_name, "
					+ "payroll.total_earnings, payroll.total_deductions, payroll.net_pay "
					+ "FROM payroll JOIN employees ON payroll.employee_id = employees.id";
			
			 	try {
					PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
					
					var ResultSet = statement.executeQuery();
					
					System.out.println(" ID | Employee Name | Total Earnings | Total Deductions | Net Pay");
					
					while(ResultSet.next())
					{

			            System.out.println(
			                ResultSet.getInt("employee_id") + " | " +
			                ResultSet.getString("employee_name") + " | " +
			                ResultSet.getDouble("total_earnings") + " | " +
			                ResultSet.getDouble("total_deductions") + " | " +
			                ResultSet.getDouble("net_pay")
			            );
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 	
		}
	

}
