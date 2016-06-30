package launch;

import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

			System.out.println("Enter the operation you want to perform. 1.List all employees to JSON file.\n 2.Create new employee 3.Import employees from JSON");
			Scanner sc = new Scanner(System.in);
			int option = sc.nextInt();
			
			switch(option) {
				
			case 1:  EmployeeDAO.selectAllEmployees();
					break;
			case 2: Employee first = new FullTime("844","Pooja","Purohit",15,PayType.HOURLY,"Web Developer");
					Employee second = new Intern("999","Prabha","Purohit",1500,PayType.HOURLY,"UNH",null,12,40);
					String s = null;
					try {
						s = mapper.writeValueAsString(first);
						System.out.println(s);
						s = mapper.writeValueAsString(second);
						System.out.println(s);
						
					}
					catch (JsonProcessingException e) {
						e.printStackTrace();
					}
					System.out.println(EmployeeDAO.insert(first));
					System.out.println(EmployeeDAO.insert(second));
					break;
			case 3: EmployeeDAO.importEmployees();
					break;
	        
		}
			sc.close();
		}

}
