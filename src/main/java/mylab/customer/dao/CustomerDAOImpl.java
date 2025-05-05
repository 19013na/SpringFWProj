package mylab.customer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import mylab.customer.vo.CustomerVO;

@Repository("customerDAO")
public class CustomerDAOImpl implements CustomerDAO{
	
	private SqlSession sqlSession;

    public CustomerDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public CustomerVO selectCustomer(int id) {
        CustomerVO customer = sqlSession.selectOne("CustomerMapper.selectCustomer", id);
    	return customer;
    }

    @Override
    public List<CustomerVO> selectAllCustomer() {
        return sqlSession.selectList("CustomerMapper.selectAllCustomer");
    }

    @Override
    public void insertCustomer(CustomerVO customer) {
        sqlSession.insert("CustomerMapper.insertCustomer", customer);
    }

}
