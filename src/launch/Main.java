package launch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.employee.util.*;
import com.employee.DAO.EmployeeDAO;
import com.employee.model.*;
import com.employee.model.Employee.PayType;

public class Main {

		public static void main(String[] args) throws Exception {

			System.out.println("Enter the operation you want to perform");
			Scanner sc = new Scanner(System.in);
			int option = sc.nextInt();
			
			switch(option) {
				
			case 1:  System.out.println(EmployeeDAO.selectAllCustomers());
					break;
			case 2: Employee first = new FullTime("844","Pooja","Purohit",15,PayType.HOURLY,"Web Developer");
					System.out.println(EmployeeDAO.insert(first));
					break;
	        
		}
		}

}
