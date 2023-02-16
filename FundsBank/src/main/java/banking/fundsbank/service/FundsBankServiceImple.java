package banking.fundsbank.service;

import java.util.List;

import banking.fundsbank.dao.FundsBankingDao;
import banking.fundsbank.dao.FundsBankingDaoImple;
import banking.fundsbank.dto.Customer;

public class FundsBankServiceImple implements FundsBankService {
	private FundsBankingDao fbDao;

	
	public FundsBankServiceImple() {
		fbDao = new FundsBankingDaoImple();
	}


	@Override
	public void closeConnection() {
		fbDao.closeConnection();
		
	}


	@Override
	public boolean createCustomer(Customer cust) {
		return fbDao.createCustomer(cust);
	}


	@Override
	public List<Customer> getCustomers() {
		return fbDao.getCustomer();
	}

}
