package com.employee.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

//Intern can be part-time or full-time
@Entity
@DiscriminatorValue(value = "Intern")
public class Intern extends Employee{
	
	private String university;
	//private Employee supervisor;
	private int lastScheduledMonth;
	private int numberHoursperWeek;
	
	Intern() {
		
	}
	
	@JsonCreator
	public Intern(@JsonProperty("SSN") String SSN,@JsonProperty("firstName") String firstName,@JsonProperty("lastName") String lastName,@JsonProperty("salary") double salary, @JsonProperty("payType") PayType payType,@JsonProperty("university") String university,@JsonProperty("supervisor") Employee supervisor,@JsonProperty("lastScheduledMonth") int lastScheduledMonth,@JsonProperty("numberHoursperWeek") int numberHoursperWeek) {
		super(SSN,firstName,lastName,salary,payType);
		//this.setBiWeeklyPay(this.calculatePay());
		this.university = university;
		//this.supervisor = supervisor;
		this.lastScheduledMonth = lastScheduledMonth;
		this.numberHoursperWeek = numberHoursperWeek;
	}
	
	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	/*public Employee getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Employee supervisor) {
		this.supervisor = supervisor;
	}*/

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
		return("SSN:" + SSN + " firstName:" + firstName + " lastName:" + lastName + "salary:" + salary + " Paytype:" + payType.toString() + " University:" + university + " lastScheduledMonth:" + lastScheduledMonth + " numberHoursperWeek:" + numberHoursperWeek);
	}
}
