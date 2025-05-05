package mylab.customer.dao.mapper;

import java.util.List;

import mylab.customer.vo.CustomerVO;

public interface CustomerMapper {
	CustomerVO selectCustomer(int id);
	List<CustomerVO> selectAllCustomer();
	void insertCustomer(CustomerVO customer);
}
