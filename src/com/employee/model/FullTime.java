package com.employee.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;

@Entity
@DiscriminatorValue(value = "FullTime")
public class FullTime extends Employee{
	String jobTitle;
	
	FullTime() {
		
	}
	
	@JsonCreator
	public FullTime(String SSN,String firstName,String lastName,double salary, PayType type,String jobTitle) {
		super(SSN,firstName,lastName,salary,type);
		this.jobTitle = jobTitle;
	}
	
	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public double calculatePay() {
		
		if(this.payType == PayType.HOURLY) {
			//Full-time employees, work for 40 hours per week. Salary is hourly rate for HOURLY payType
			return salary*40*2;
		}
		else {
			//Salary is annual for PayType YEARLY which is 52 weeks
			return (salary/52)*2;
		}
	}
}
