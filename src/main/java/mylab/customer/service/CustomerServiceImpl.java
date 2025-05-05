package mylab.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mylab.customer.dao.CustomerDAO;
import mylab.customer.service.CustomerService;
import mylab.customer.vo.CustomerVO;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDAO customerDAO;

	@Override
	public List<CustomerVO> getAllCustomerList() {
		return customerDAO.selectAllCustomer();
	}

	@Override
	public CustomerVO getCustomerInfo(int id) {
		return customerDAO.selectCustomer(id);
	}

	@Override
	public void insertCustomer(CustomerVO customer) {
		customerDAO.insertCustomer(customer);
	}
}
