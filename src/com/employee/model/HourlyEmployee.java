/*
 * Hourly class is extended from Employee. Salary of hourly employee is the per hour rate.
 * 
 */
package com.employee.model;

import java.util.Scanner;



public class HourlyEmployee extends Employee{
	
	HourlyEmployee(String SSN,String firstName,String lastName,double salary, EmployeeType type) {
		super(SSN,firstName,lastName,salary,type);
	}
	
	public double calculatePay() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the number of hours worked by employee ID " + this.getSSN() + " during the half month pay period");
		double workingHours = sc.nextDouble();
		sc.close();
		return salary * workingHours;
		
	}

}
