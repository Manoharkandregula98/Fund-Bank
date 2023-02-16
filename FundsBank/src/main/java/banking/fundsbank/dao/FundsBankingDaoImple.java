package banking.fundsbank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import banking.fundsbank.dto.Customer;
import banking.fundsbank.util.DBUtil;

public class FundsBankingDaoImple implements FundsBankingDao {
	private static Connection con = DBUtil.getConnection();
	private static Map<Long, Customer> cset = new HashMap<>();
	
	@Override
	public boolean createCustomer(Customer cust) {
		String query = "insert into customer values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setLong(1, cust.getAccNo());
			pst.setString(2, cust.getFirstName());
			pst.setString(3, cust.getLastName());
			pst.setInt(4, cust.getAge());
			pst.setLong(5, cust.getMobileNumber());
			pst.setString(6, cust.getAccountType());
			pst.setString(7, cust.getAddress());
			int rows = pst.executeUpdate();
			if (rows > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public List<Customer> getCustomer() {
		PreparedStatement pst;
		List<Customer> list = null;
		String qry = "select acc_num,first_name,last_name,age,mobile_num,account_type,address from customer";
		try {
			pst = con.prepareStatement(qry);
			ResultSet rst = pst.executeQuery();
			while (rst.next()) {
				Customer cust = new Customer(rst.getLong(1), rst.getString(2), rst.getString(3), rst.getInt(4), rst.getLong(5), rst.getString(6), rst.getString(7));
				cset.put(rst.getLong(1), cust);
			}
			Collection<Customer> calcust = cset.values();
			list = new ArrayList<>(calcust);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public void closeConnection() {
		DBUtil.closeConnection();

	}


}
