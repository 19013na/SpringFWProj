package mylab.customer.dao;

import java.util.List;

import mylab.customer.vo.CustomerVO;

public interface CustomerDAO {
	CustomerVO selectCustomer(int id);
	List<CustomerVO> selectAllCustomer();
	void insertCustomer(CustomerVO customer);
}
