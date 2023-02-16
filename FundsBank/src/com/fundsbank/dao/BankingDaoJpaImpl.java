package com.fundsbank.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fundsbank.dto.Customer;
import com.fundsbank.util.JPAUtil;


public class BankingDaoJpaImpl implements BankingDao {

	

	private EntityManager em;
	private static final double MIN_BAL = 1000;

	public BankingDaoJpaImpl() {
		em = JPAUtil.getEntityManager();
	}

	

	@Override
	public boolean createCustomer(Customer cust) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(cust);
		em.getTransaction().commit();
		return true;
	}
	
	@Override
	public List<Customer> getCustomers() {
		String qry = "Select cust from Customer cust";
		TypedQuery<Customer> query = em.createQuery(qry, Customer.class);
		List<Customer> custList = query.getResultList();
		//custList.stream().forEach(s->System.out.println(s+"\n"));
		//JPAUtil.close();
		return custList;
	}
	
	public void close() {
		JPAUtil.close();
	}

	
	
}
