package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.CustomerDao;
import util.DBUtil;
import vo.Customer;

public class CustomerService {
	CustomerDao customerDao;

	// LoginController 고객로그인
	public Customer CustomerLogin(Customer paramCustomer) {
		customerDao = new CustomerDao();
		Customer resultCustomer = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			resultCustomer = customerDao.selectCustomerByIdAndPw(conn, paramCustomer);
			conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} 
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultCustomer;
	}
	
	// EmpAddController 고객 회원가입
	public int getAddCustomer(Customer customer) {
		int row = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			customerDao = new CustomerDao();
			row = customerDao.addCustomer(conn, customer);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	
	
}
