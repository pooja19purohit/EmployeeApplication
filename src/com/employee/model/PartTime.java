package com.employee.model;

import com.employee.model.Employee.PayType;

//TODO: Define calculatePay
public class PartTime extends Employee {
	
	private int lastScheduledMonth;
	private int numberHoursperWeek;
	
	PartTime(String SSN,String firstName,String lastName,double salary, PayType type) {
		super(SSN,firstName,lastName,salary,type);
	}
	
	PartTime(String SSN,String firstName,String lastName,double salary, PayType type,int lastScheduledMonth,int numberHoursperWeek) {
		super(SSN,firstName,lastName,salary,type);
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
			return numberHoursperWeek*perHour;
		}
	}

}
