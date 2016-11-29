package com.shsxt.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.model.Customer;
import com.shsxt.crm.vo.CustomerVo;

public interface CustomerDao extends BaseDao<Customer> {

	@Select("select id, name from t_customer where isValid = 1 and state = 0 ")
	public List<CustomerVo> listAll();
	
	@Select("select id, name, khno as customerNo from t_customer where id = #{cusId}")
	public CustomerVo findVoById(@Param(value="cusId") Integer cusId);

	
	public List<Customer> findNoOrdersCustomer();

	public List<Customer> findLossCustomer();
	
	

}
