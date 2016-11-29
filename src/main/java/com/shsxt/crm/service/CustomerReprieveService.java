package com.shsxt.crm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shsxt.crm.dao.CustomerReprieveDao;
import com.shsxt.crm.model.CustomerReprieve;
import com.shsxt.crm.util.AssertUtil;

@Service
public class CustomerReprieveService {
	
	@Autowired
	private CustomerReprieveDao customerReprieveDao;
	
	public Map<String, Object> findLossReprieve(Integer lossId) {
		List<CustomerReprieve> customers = customerReprieveDao
				.findLossReprieve(lossId);
		Map<String, Object> result = new HashMap<>();
		result.put("rows", customers);
		return result;
	}

	public void addOrUpdate(CustomerReprieve customerReprieve) {
		Integer lossId = customerReprieve.getLossId();
		AssertUtil.isTrue(lossId == null || lossId < 1, "请选择一条记录");
		String meassure = customerReprieve.getMeasure();
		AssertUtil.notEmpty(meassure, "请输入暂缓措施");
		if (customerReprieve.getId() == null) { // save
			customerReprieveDao.insert(customerReprieve);
		} else { // update
			customerReprieveDao.update(customerReprieve);
		}
	}

	public void delete(Integer id) {
		AssertUtil.isTrue(id == null || id < 1, "请选择一条记录");
		customerReprieveDao.delete(id);
	}
	
}
