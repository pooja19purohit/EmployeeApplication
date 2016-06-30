package com.employee.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-06-30T02:32:59.587-0400")
@StaticMetamodel(Intern.class)
public class Intern_ extends Employee_ {
	public static volatile SingularAttribute<Intern, String> university;
	public static volatile SingularAttribute<Intern, Integer> lastScheduledMonth;
	public static volatile SingularAttribute<Intern, Integer> numberHoursperWeek;
}
