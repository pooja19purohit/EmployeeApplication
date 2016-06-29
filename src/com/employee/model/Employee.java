package com.employee.model;

public abstract class Employee {
	protected String SSN;
	protected String firstName;
	protected String lastName;
	protected double salary;
	protected String employeeType;
	
	protected static enum EmployeeType
	{
	    Contract,
	    FullTime,
	    PartTime,
	    Intern
	}
	
	Employee(String SSN,String firstName,String lastName,double salary, EmployeeType type) {
		this.SSN = SSN;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.employeeType = type.toString();
	}
	
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		SSN = sSN;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
}
