package com.fundsbank.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fundsbank.dto.Customer;


public class BankingDaoImpl implements BankingDao {
	private static final double MIN_BALANCE = 1000;
	private Map<Long, Customer> custMap = new HashMap<>();
	
	@Override
	public List<Customer>getCustomers(){
		Collection<Customer> custCollection = custMap.values();
		List<Customer>custList = new ArrayList<>(custCollection);
		return custList;
	}
	
	
	@Override
	public boolean createCustomer(Customer cust) {
		Customer old = custMap.put(cust.getAdhaarNo(), cust);
		if(old==null) {
		return true;
		}
		return false;
	}
	
}
