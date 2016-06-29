package com.employee.model;

public class SalariedEmployee extends Employee{
	
	SalariedEmployee(String SSN,String firstName,String lastName,double salary, EmployeeType type) {
		super(SSN,firstName,lastName,salary,type);
	}
	
	public double calculatePay() {
		
		/* The salary is divided by 24 since it is paid every half a month
		 */
		return salary/24;
		
	}
}
