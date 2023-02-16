package banking.fundsbank.dao;

import java.util.List;

import banking.fundsbank.dto.Customer;

public interface FundsBankingDao {

	void closeConnection();

	boolean createCustomer(Customer cust);

	List<Customer> getCustomer();

}
