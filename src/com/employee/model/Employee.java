package com.employee.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use = Id.NAME,
include = JsonTypeInfo.As.PROPERTY,
property = "EMPLOYEE_TYPE")
@JsonSubTypes({
@Type(value = FullTime.class, name="FullTime"),
@Type(value = PartTime.class, name="PartTime"),
@Type(value = Intern.class, name="Intern")
})

@Entity(name="employees")
@Table(name="employees")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "EMPLOYEE_TYPE")
public abstract class Employee {
	@javax.persistence.Id
	@Column(name = "SSN", unique=true, nullable=false)
	protected String SSN;
	protected String firstName;
	protected String lastName;
	protected double salary;
	protected double biWeeklyPay;

	//@Transient
	protected PayType payType;

	public static enum PayType
	{
	    HOURLY,
	    YEARLY
	}
	
	//JPA was throwing an error that default constructor was not present
	Employee() {
		
	}
	public Employee(String SSN,String firstName,String lastName,double salary, PayType type) {
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
	
	public double getBiWeeklyPay() {
		return biWeeklyPay;
	}
	public void setBiWeeklyPay(double biWeeklyPay) {
		this.biWeeklyPay = biWeeklyPay;
	}
	
	
	//Calculates bi-weekly pay
	public abstract double calculatePay();
}
