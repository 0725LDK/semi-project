package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

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
			
			if(customerDao.addCustomer(conn, customer) != 1) {
				System.out.println("실패 getAddCustomer : customerDao.addCustomer");
				throw new Exception(); // 회원가입 실패시 강제로 예외를 발생시켜 catch절로 이동하여 롤백
			}
			if(customerDao.addPwHistory(conn, customer) != 1) {
				System.out.println("실패 getAddCustomer : customerDao.addPwHistory");
				throw new Exception(); // pw_history 입력 실패시 강제로 예외를 발생시켜 catch절로 이동하여 롤백
			}
			if(customerDao.addCustomerAddress(conn, customer) != 1) {
				System.out.println("실패 getAddCustomer : customerDao.addCustomerAddress");
				throw new Exception(); // addCustomerAddress 입력 실패시 강제로 예외를 발생시켜 catch절로 이동하여 롤백
			}
			
			result = 1; // 성공
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
			
			if(customerDao.modifyCustomer(conn, customer) != 1) {
				System.out.println("실패 getModifyCustomer : customerDao.modifyCustomer");
				throw new Exception(); // 정보수정 실패시 강제로 예외를 발생시켜 catch절로 이동하여 롤백
			}
			if(customerDao.addPwHistory(conn, customer) != 1) {
				System.out.println("실패 getModifyCustomer : customerDao.addPwHistory");
				throw new Exception(); // pw_history 입력 실패시 강제로 예외를 발생시켜 catch절로 이동하여 롤백
			}
			customerDao.removePwHistoryByFour(conn, customer); // pwHistory데이터 4개이상이면 삭제
			
			result = 1; // 성공
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
	
	// CustomerRemoveController 회원탈퇴시 outid입력, pwHistory삭제
	public int getRemoveCustomer(Customer customer) {
		int row = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			customerDao = new CustomerDao();
			
			if(customerDao.addOutId(conn, customer) != 1) {
				System.out.println("실패 getRemoveCustomer : customerDao.addOutId");
				throw new Exception(); // outId 입력 실패시 강제로 예외를 발생시켜 catch절로 이동하여 롤백
			}
			if(customerDao.removePwHistory(conn, customer) == 0) { // return값 0:실패, 1~3:성공
				System.out.println("실패 getRemoveCustomer : customerDao.removePwHistory");
				throw new Exception(); // pw_history 삭제 실패시 강제로 예외를 발생시켜 catch절로 이동하여 롤백
			}
			if(customerDao.removeCustomer(conn, customer) != 1) {
				System.out.println("실패 getRemoveCustomer : customerDao.removeCustomer");
				throw new Exception(); // customer 삭제가 안되면 강제로 예외를 발생시켜 catch절로 이동하여 롤백
			}
			
			row = 1; //성공
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
	
	//고객 포인트 조회+업데이트
	public int customerPointUpdate(String customerId)
	{
		customerDao = new CustomerDao();
		int row = 0;
		int searchPoint = 0;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			searchPoint = customerDao.customerSearchPoint(conn, customerId);
			System.out.println(searchPoint+"<--searchPoint custormerCervice");
			row = customerDao.customerPointUpdate(conn, searchPoint, customerId);
			System.out.println(row+"<--row custormerCervice");
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		return row;
	}
	
	// CustomerCartAddAddressController 주문시 주소추가
	public int getAddCustomerAddress(Customer customer) {
		int row = 0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			customerDao = new CustomerDao();
			row = customerDao.addCustomerAddress(conn, customer);
			conn.commit();
		} catch (Exception e) {
			try {
				System.out.println("롤백 CustomerService : getAddCustomerAddress");
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
	
	// CustomerCartAddAddressController 주문시 주소추가
	public ArrayList<CustomerAddress> getSelectCustomerAddressList(String customerId) {
		ArrayList<CustomerAddress> list = new ArrayList<CustomerAddress>();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			customerDao = new CustomerDao();
			list = customerDao.selectCustomerAddressList(conn, customerId);
			conn.commit();
		} catch (Exception e) {
			try {
				System.out.println("롤백 CustomerService : getAddCustomerAddress");
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
		return list;
	}
	
}