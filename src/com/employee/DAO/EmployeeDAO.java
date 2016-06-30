package com.employee.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import com.employee.util.*;
import com.employee.model.*;

public class EmployeeDAO {
	
	public static List<Employee> selectAllCustomers() {
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Query query = em.createQuery("SELECT e FROM employees e");
        
        List<Employee> results = new ArrayList<Employee>();
        try {
            results.addAll(query.getResultList());
        } catch (Exception e) {
            
        } finally {
            em.close();
        }
        
        return results;
    }
	
	public static boolean insert(Employee employee) {
        boolean success = true;
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            if (!trans.isActive()) trans.begin();
            em.persist(employee);
            trans.commit();
        } catch (Exception e) {
            if (trans.isActive()) trans.rollback();
            System.out.println((Employee.class.getName()));
            success = false;
        } finally {
            em.close();
        }
        
        return success;
    }
	
	public static boolean update(Employee employee) {
        boolean success = true;
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            if (!trans.isActive()) trans.begin();
            em.merge(employee);
            trans.commit();
        } catch (Exception e) {
            if (trans.isActive()) trans.rollback();
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
