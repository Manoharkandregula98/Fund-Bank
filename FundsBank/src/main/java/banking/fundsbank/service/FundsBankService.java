package banking.fundsbank.service;

import java.util.List;

import banking.fundsbank.dto.Customer;

public interface FundsBankService {

	void closeConnection();

	boolean createCustomer(Customer cust);

	List<Customer> getCustomers();

}
