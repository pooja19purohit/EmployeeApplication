package com.employee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name="employees")
@Table(name="employees")
public class Employee {
	@Id
	@Column(name = "SSN", unique=true, nullable=false)
	protected String SSN;
	protected String firstName;
	protected String lastName;
	protected double salary;
	//@Transient
	protected PayType payType;

	protected static enum PayType
	{
	    HOURLY,
	    YEARLY
	}
	
	Employee() {
		
	}
	Employee(String SSN,String firstName,String lastName,double salary, PayType type) {
		this.SSN = SSN;
		this.firstName = firstName;
		this.lastName = lastName;
		//if payType is hourly, salary is per hour rate else it is per year rate
		this.salary = salary;
		this.payType = type;
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
	public PayType getPayType() {
		return payType;
	}

	public void setPayType(PayType payType) {
		this.payType = payType;
	}

	
	
	//Calculates bi-weekly pay
	//public abstract double calculatePay();
}
