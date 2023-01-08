package service;

import java.sql.Connection;

import java.sql.SQLException;

import dao.CustomerDao;
import util.DBUtil;
import vo.Customer;
import vo.Customer_address;

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
				System.out.println("롤백 CustomerService : CustomerLogin");
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
	
	// CustomerOneController 회원정보
	public Customer getSelectCustomerOne(String customerId) {
		Customer customer = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			customerDao = new CustomerDao();
			customer = customerDao.selectCustomerByOne(conn, customerId);
			conn.commit();
		} catch(Exception e) {
			try {
				System.out.println("롤백 CustomerService : getSelectCustomerOne");
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
		return customer;
	}
	
	
	// CustomerAddController 아이디 중복검사
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
				System.out.println("롤백 CustomerService : getIdCheck");
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
	
	// CustomerAddController 고객 회원가입, pw_history, customer_address 입력
	public int getAddCustomer(Customer customer) {
		int result = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection(); // db접속 자동커밋해지
			customerDao = new CustomerDao();
			if(customerDao.addCustomer(conn, customer) == 1) {
				if(customerDao.addPwHistory(conn, customer) == 1) {
					if(customerDao.addCustomerAddress(conn, customer) != 1) {
						throw new Exception(); // addCustomerAddress 입력 실패시 강제로 예외를 발생시켜 catch절로 이동하여 롤백
					}
					result = 1; // 성공
				}
				throw new Exception(); // addPwHistory 입력 실패시 강제로 예외를 발생시켜 catch절로 이동하여 롤백
			}
			conn.commit(); // 쿼리 커밋
		} catch (Exception e) {
			try {
				System.out.println("롤백 CustomerService : getAddCustomer");
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
	
	// CustomerModifyController 현재 비밀번호 확인
	public int getPasswordCheck(String customerId, String customerPw) {
		int row = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			customerDao = new CustomerDao();
			row = customerDao.passwordCheck(conn, customerId, customerPw);
			conn.commit();
		} catch (Exception e) {
			try {
				System.out.println("롤백 CustomerService : getPasswordCheck");
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
	
	// CustomerModifyController 최근비밀번호 3개중 중복확인
	public boolean getNewPasswordCheck(Customer customer) {
		boolean result = true;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			customerDao = new CustomerDao();
			result = customerDao.newPasswordCheck(conn, customer);
			conn.commit();
		} catch (Exception e) {
			try {
				System.out.println("롤백 CustomerService : getNewPasswordCheck");
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
	
	// CustomerModifyController 회원정보 수정
	public int getModifyCustomer(Customer customer) {
		int result = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			customerDao = new CustomerDao();
			if(customerDao.modifyCustomer(conn, customer) == 1) {
				if(customerDao.addPwHistory(conn, customer) == 0) {
					throw new Exception(); // pw_history 입력 실패시 강제로 예외를 발생시켜 catch절로 이동하여 롤백
				}
				result = 1; // 성공
			}
			conn.commit();
		} catch (Exception e) {
			try {
				System.out.println("롤백 CustomerService : getModifyCustomer");
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
	
	// CustomerRemoveController 회원탈퇴, outid입력, customerAddress삭제, pwHistory삭제
	public int getRemoveCustomer(Customer customer) {
		int row = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			customerDao = new CustomerDao();
			if(customerDao.addOutId(conn, customer) == 1) {
				if(customerDao.removeCustomerAddress(conn, customer) == 1) {
					if(customerDao.removePwHistory(conn, customer) == 1) {
						if(customerDao.removeCustomer(conn, customer) != 1) {
							throw new Exception(); // customer 삭제가 안되면 강제로 예외를 발생시켜 catch절로 이동하여 롤백
						}
						row = 1; //성공
					}
					throw new Exception(); // pwHistory 삭제가 안되면 강제로 예외를 발생시켜 catch절로 이동하여 롤백
				}
				throw new Exception(); // customerAddress 삭제가 안되면 강제로 예외를 발생시켜 catch절로 이동하여 롤백
			}
			conn.commit();
		} catch (Exception e) {
			try {
				System.out.println("롤백 CustomerService : getRemoveCustomer");
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
