package mylab.customer.service;
import java.util.List;

import mylab.customer.vo.CustomerVO;

public interface CustomerService {
	List<CustomerVO> getAllCustomerList();
	CustomerVO getCustomerInfo(int id);
	void insertCustomer(CustomerVO customer);
}
