package com.employee.model;

import com.employee.model.Employee.PayType;

//Intern can be part-time or full-time
public class Intern extends Employee{
	
	private String university;
	private Employee supervisor;
	private int lastScheduledMonth;
	private int numberHoursperWeek;
	
	Intern(String SSN,String firstName,String lastName,double salary, PayType type) {
		super(SSN,firstName,lastName,salary,type);
	}
	
	Intern(String SSN,String firstName,String lastName,double salary, PayType type,String university,Employee supervisor,int lastScheduledMonth, int numberHoursperWeek) {
		super(SSN,firstName,lastName,salary,type);
		this.university = university;
		this.supervisor = supervisor;
		this.lastScheduledMonth = lastScheduledMonth;
		this.numberHoursperWeek = numberHoursperWeek;
	}
	
	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public Employee getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Employee supervisor) {
		this.supervisor = supervisor;
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
