package com.fundsbank.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.fundsbank.dao.BankingDao;
import com.fundsbank.dto.Customer;
import com.fundsbank.util.DBUtil;


public class BankingDaoJdbcImpl implements BankingDao {
	private static final double MIN_BALANCE = 1000;
	private Logger logger = Logger.getLogger(BankingDaoJdbcImpl.class);

	@Override
	public List<Customer> getCustomers() {
		List<Customer>custlist = new ArrayList<>();
		String query = "select accno, name, mobile,balance from customer";
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement stmt  = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Customer cust = new Customer(rs.getLong(1), rs.getString(2),rs.getLong(3), rs.getDouble(4));
				custlist.add(cust);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		}
		return custlist;
	}

	

	@Override
	public boolean createCustomer(Customer cust) {
		logger.info(cust);
		String query = "insert into customer(accno,name,mobile,balance) values (?,?,?,?)";
		Connection conn =DBUtil.getConnection();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(query);
			stmt.setLong(1,cust.getAdhaarNo());
			stmt.setString(2, cust.getFirstName());
			stmt.setLong(4,cust.getMobileNo());
			stmt.setString(3, cust.getLastName());
			int rows = stmt.executeUpdate();
			if(rows>0) {
			return true;
			}else 
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		}
		return false;
	}

	

}
