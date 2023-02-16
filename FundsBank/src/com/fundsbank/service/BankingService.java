package com.fundsbank.service;

import java.util.List;

import com.fundsbank.dto.Address;
import com.fundsbank.dto.Customer;


public interface BankingService {

	List<Customer> getCustomers();
	List<Address> getAddresses();

	boolean createCustomer(Customer cust);
	boolean createAddress(Address add);
	

}
