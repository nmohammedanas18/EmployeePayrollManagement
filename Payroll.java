package com.payroll;

public class Payroll {
	
	private int id;
	private int employeeId;
	
	private double basic;
	private double hra;
	private double ta;
	private double medicalAllowance;
	private double specialAllowance;
	
	private double pf;
	private double esic;
	private double professionalTax;
	
	private double totalEarnings;
	private double totalDeductions;
	private double netPay;
	
	public Payroll(int employeeId,
			double basic,
			double hra,
			double ta,
			double medicalAllowance,
			double specialAllowance,
			double pf,
			double esic,
			double professionalTax)
	{
		this.employeeId=employeeId;
		this.basic=basic;
		this.hra=hra;
		this.ta=ta;
		this.medicalAllowance=medicalAllowance;
		this.specialAllowance=specialAllowance;
		this.pf=pf;
		this.esic=esic;
		this.professionalTax=professionalTax;
	}
	
	public void calculatePayroll() {
		
		totalEarnings = basic+hra+ta+medicalAllowance+specialAllowance;
		
		totalDeductions = pf + esic + professionalTax;
				
		netPay=totalEarnings - totalDeductions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	public double getHra() {
		return hra;
	}

	public void setHra(double hra) {
		this.hra = hra;
	}

	public double getTa() {
		return ta;
	}

	public void setTa(double ta) {
		this.ta = ta;
	}

	public double getMedicalAllowance() {
		return medicalAllowance;
	}

	public void setMedicalAllowance(double medicalAllowance) {
		this.medicalAllowance = medicalAllowance;
	}

	public double getSpecialAllowance() {
		return specialAllowance;
	}

	public void setSpecialAllowance(double specialAllowance) {
		this.specialAllowance = specialAllowance;
	}

	public double getPf() {
		return pf;
	}

	public void setPf(double pf) {
		this.pf = pf;
	}

	public double getEsic() {
		return esic;
	}

	public void setEsic(double esic) {
		this.esic = esic;
	}

	public double getProfessionalTax() {
		return professionalTax;
	}

	public void setProfessionalTax(double professionalTax) {
		this.professionalTax = professionalTax;
	}

	public double getTotalEarnings() {
		return totalEarnings;
	}

	public void setTotalEarnings(double totalEarnings) {
		this.totalEarnings = totalEarnings;
	}

	public double getTotalDeductions() {
		return totalDeductions;
	}

	public void setTotalDeductions(double totalDeductions) {
		this.totalDeductions = totalDeductions;
	}

	public double getNetPay() {
		return netPay;
	}

	public void setNetPay(double netPay) {
		this.netPay = netPay;
	}
	
	
	

}


