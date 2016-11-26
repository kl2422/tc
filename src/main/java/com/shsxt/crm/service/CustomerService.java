package com.shsxt.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shsxt.crm.dao.CustomerDao;
import com.shsxt.crm.vo.CustomerVo;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	/**
	 * 获取所有的客户
	 * @return
	 */
	public List<CustomerVo> findAll() {
		List<CustomerVo> customerVos = customerDao.listAll();
		return customerVos;
	}
	
}	
