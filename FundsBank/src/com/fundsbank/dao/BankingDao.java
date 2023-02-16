package com.fundsbank.dao;

import java.util.List;

import com.fundsbank.dto.Customer;



public interface BankingDao {

	List<Customer> getCustomers();


		boolean createCustomer(Customer cust);


}
