package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.CustomerDao;
import util.DBUtil;
import vo.Customer;
import vo.CustomerAddress;

public class CustomerService {
	private CustomerDao customerDao;

	// LoginController 고객로그인
	public Customer CustomerLogin(Customer paramCustomer) {
		Customer resultCustomer = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			customerDao = new CustomerDao();
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
	
	// 아이디 중복검사
	public boolean getIdCheck(String idCheck) {
		boolean result = true;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			customerDao = new CustomerDao();
			result = customerDao.checkId(conn, idCheck);
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
		return result;
	}
	
	// EmpAddController 고객 회원가입, customer_address
	public int getAddCustomer(Customer customer, CustomerAddress customerAddress) {
		int result = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			customerDao = new CustomerDao();
			if(customerDao.addCustomer(conn, customer) == 1) {
				if(customerDao.addCustomerAddress(conn, customerAddress) != 1) {
					throw new Exception(); // addCustomerAddress 입력 실패시 강제로 예외를 발생시켜 catch절로 이동하여 롤백
				}
				result = 1;
			}
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
		return result;
	}
	
	
	
}
