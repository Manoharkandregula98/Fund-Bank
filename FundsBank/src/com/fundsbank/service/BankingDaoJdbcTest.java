package com.fundsbank.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.banking.dto.Customer;
import com.cg.bankingexception.BankingException;
import com.fundsbank.dao.BankingDao;

public class BankingDaoJdbcTest {
	private BankingDao bDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDeposit() throws BankingException {
		double balance = bDao.deposit(12001100222L, 1000.0);
		assertEquals(11000, balance,0.1);
	}

	@Test
	public void testWithdraw() throws BankingException {
		double balance = bDao.withdraw(123443211234L, 1000.0);
		assertEquals(22500, balance,0.1);
	}

	@Test
	public void testGetBalance() throws BankingException {
		double balance = bDao.getBalance(123412345566L);
		assertEquals(29000, balance,0.1);
	}

	@Test
	public void testCreateCustomer() {
			Customer cust = new Customer(12001100222L, "Rishabh", 9000881100L, 7000.0);
			boolean success = bDao.createCustomer(cust);
			assertTrue(success);
	}

}
