package com.employee.DAO;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.employee.util.*;
import com.employee.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeDAO {

	static ObjectMapper mapper = new ObjectMapper();
	static EntityManager em = DBUtil.getEmFactory().createEntityManager();

	// Function to export current employees to JSON file
	@SuppressWarnings("unchecked")
	public static List<Employee> selectAllEmployees() {
		Query query = em.createQuery("SELECT e FROM employees e");

		List<Employee> results = new ArrayList<Employee>();

		try {
			results.addAll(query.getResultList());
			mapper.writeValue(new File("/tmp/result.json"), results);
		}

		catch (Exception e) {

		} finally {
			// em.close();
		}

		return results;
	}

	// Function to import employees from JSON File
	public static boolean importEmployees() {

		try {
			// EMPLOYEE_TYPE has to be specified for each object in the JSON
			List<Employee> employees = Arrays.asList(mapper.readValue(new File(
					"/tmp/input.json"), Employee[].class));
			for (Employee employee : employees) {
				insert(employee);
			}
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;

		}
		return true;
	}

	public static boolean insert(Employee employee) {
		boolean success = true;
		// EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			if (!trans.isActive())
				trans.begin();
			em.persist(employee);
			trans.commit();
		} catch (Exception e) {
			if (trans.isActive())
				trans.rollback();
			System.out.println((Employee.class.getName()));
			success = false;
		} finally {
			// em.close();
		}

		return success;
	}

	public static boolean update(Employee employee) {
		boolean success = true;
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			if (!trans.isActive())
				trans.begin();
			em.merge(employee);
			trans.commit();
		} catch (Exception e) {
			if (trans.isActive())
				trans.rollback();
			System.out.println(e.getMessage());
			success = false;
		} finally {
			em.close();
		}

		return success;
	}

	public static Employee selectEmployeeBySSN(String SSN) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String query = "SELECT c FROM employees c WHERE c.SSN = :SSN";
		TypedQuery<Employee> tq = em.createQuery(query, Employee.class);
		tq.setParameter("SSN", SSN);
		Employee result = null;
		try {
			result = tq.getSingleResult();
		} catch (Exception e) {

		} finally {
			em.close();
		}

		return result;
	}
}
