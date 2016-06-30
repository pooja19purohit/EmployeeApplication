package launch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.employee.util.*;
import com.employee.model.*;

public class Main {

		public static void main(String[] args) throws Exception {

			System.out.println("Enter the operation you want to perform");
			Scanner sc = new Scanner(System.in);
			int option = sc.nextInt();
			
			switch(option) {
				
			case 1:  EntityManager em = DBUtil.getEmFactory().createEntityManager();
			Query query = em.createQuery("SELECT e FROM employees e");
	        //TypedQuery tq = em.createQuery(query, Employee.class);
	        System.out.println(query.getResultList());
	        
		}
		}

}
