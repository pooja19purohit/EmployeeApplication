package com.employee.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@DiscriminatorValue(value = "FullTime")
public class FullTime extends Employee{
	String jobTitle;
	
	FullTime() {
		
	}
	
	@JsonCreator
	public FullTime(@JsonProperty("SSN") String SSN,@JsonProperty("firstName") String firstName,@JsonProperty("lastName") String lastName,@JsonProperty("salary") double salary, @JsonProperty("payType") PayType payType,@JsonProperty("jobTitle") String jobTitle) {
		super(SSN,firstName,lastName,salary,payType);
		//this.setBiWeeklyPay(this.calculatePay());
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
	
	public String toString() {
		return("SSN:" + SSN + " firstName:" + firstName + " lastName:" + lastName + "salary:" + salary + " Paytype:" + payType.toString() + " JobTitle:" + jobTitle);
	}
}
