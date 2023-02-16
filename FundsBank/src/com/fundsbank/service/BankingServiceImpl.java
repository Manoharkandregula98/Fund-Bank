package com.fundsbank.service;

import java.util.List;


import com.fundsbank.dao.BankingDao;
import com.fundsbank.dao.BankingDaoImpl;
import com.fundsbank.dao.BankingDaoJpaImpl;
import com.fundsbank.dto.Address;
import com.fundsbank.dto.Customer;
import com.fundsbank.exception.BankingException;

public class BankingServiceImpl implements BankingService {
	private BankingDao bDao;
	public BankingServiceImpl() {
		//bDao = new BankingDaoImpl();
		//bDao = new BankingDaoJdbcImpl();
		bDao = new BankingDaoJpaImpl();
	}
	
	
	@Override
	public boolean createCustomer(Customer cust) {
		
		return bDao.createCustomer(cust);
	}

	@Override
	public List<Customer> getCustomers() {
		return bDao.getCustomers();
	}


	@Override
	public List<Address> getAddresses() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean createAddress(Address add) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
