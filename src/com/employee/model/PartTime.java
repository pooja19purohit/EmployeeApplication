package com.employee.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@DiscriminatorValue(value = "PartTime")
public class PartTime extends Employee {
	
	private int lastScheduledMonth;
	private int numberHoursperWeek;
	
	PartTime() {
		
	}
	
	@JsonCreator
	PartTime(@JsonProperty("SSN") String SSN,@JsonProperty("firstName") String firstName,@JsonProperty("lastName") String lastName,@JsonProperty("salary") double salary, @JsonProperty("payType") PayType payType,@JsonProperty("lastScheduledMonth") int lastScheduledMonth,@JsonProperty("numberHoursperWeek") int numberHoursperWeek) {
		super(SSN,firstName,lastName,salary,payType);
		//this.setBiWeeklyPay(this.calculatePay());
		this.lastScheduledMonth = lastScheduledMonth;
		this.numberHoursperWeek = numberHoursperWeek;
		
	}

	public int getLastScheduledMonth() {
		return lastScheduledMonth;
	}

	public void setLastScheduledMonth(int lastScheduledMonth) {
		this.lastScheduledMonth = lastScheduledMonth;
	}
	
	public int getNumberHoursperWeek() {
		return numberHoursperWeek;
	}

	public void setNumberHoursperWeek(int numberHoursperWeek) {
		this.numberHoursperWeek = numberHoursperWeek;
	}

	public double calculatePay() {
		if(this.payType == PayType.HOURLY) {
			//Full-time employees, work for 40 hours per week. Salary is hourly rate for HOURLY payType
			return salary*numberHoursperWeek*2;
		}
		else {
			//Salary is annual for PayType YEARLY which is 52 weeks
			double perHour = (salary/52)/numberHoursperWeek;
			return numberHoursperWeek*perHour*2;
		}
	}
	
	public String toString() {
		return("SSN:" + SSN + " firstName:" + firstName + " lastName:" + lastName + "salary:" + salary + " Paytype:" + payType.toString() + " lastScheduledMonth:" + lastScheduledMonth + " numberHoursperWeek:" + numberHoursperWeek);
	}

}
