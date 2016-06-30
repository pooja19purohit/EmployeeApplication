# EmployeeApplication

Backend part of a Java Application for Employee Management.

1.Created an **Abstract** Employee class and Different types of employees inherit from it. I have created ENUMs for Salary_type. Each employee type can either have HOURLY or YEARLY salary.
This design is extendable since New Employee_Type and Salary_Type can be added without having to change underlying code.

2.Used **JPA, JDBC** for Object-Relation Mapping and connecting to the localhost database. Database can be pushed to cloud – I have created a ClearDB database on Heroku.
  I used **JPA single table inheritance** design. For advanced real-time scenario, multiple classes with Joins can be used.

3.Used **Jackson** to read/write employees from JSON file. I have used @Inheritance and @DiscriminatorColumn EMPLOYEE_TYPE to distinguish between each type of employee. 
