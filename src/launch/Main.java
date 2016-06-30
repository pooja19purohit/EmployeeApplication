package launch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.employee.util.*;
import com.employee.DAO.EmployeeDAO;
import com.employee.model.*;
import com.employee.model.Employee.PayType;

/*
 * TODO: Read JSON from file and write to file
 * TODO: Host Database on cloud
 * TODO: Documentation in READ.ME - Include Design Objective, Single table JPA inheritance, Jackson
 */
public class Main {

		public static void main(String[] args) throws Exception {
			ObjectMapper mapper = new ObjectMapper();

			System.out.println("Enter the operation you want to perform");
			Scanner sc = new Scanner(System.in);
			int option = sc.nextInt();
			
			switch(option) {
				
			case 1:  List<Employee> results = EmployeeDAO.selectAllCustomers();
					String sjson = null;
					for(Employee result:results) {
						sjson = mapper.writeValueAsString(result);
						System.out.println("JSON is " + sjson);
						System.out.println(result);
					}
					break;
			case 2: Employee first = new FullTime("844","Pooja","Purohit",15,PayType.HOURLY,"Web Developer");
					String s = null;
					try {
						s = mapper.writeValueAsString(first);
					}
					catch (JsonProcessingException e) {
						e.printStackTrace();
					}
					System.out.println(s);
					System.out.println(EmployeeDAO.insert(first));
					break;
	        
		}
		}

}
