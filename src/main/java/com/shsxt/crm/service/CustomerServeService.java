package com.shsxt.crm.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.shsxt.crm.dao.CustomerServeDao;
import com.shsxt.crm.model.CustomerServe;
import com.shsxt.crm.query.CustomerServeQuery;

@Service
public class CustomerServeService {
	
	@Autowired
	private CustomerServeDao customerServeDao;

	public Map<String, Object> selectForPage(CustomerServeQuery query) {
		PageList<CustomerServe> customerServes = (PageList<CustomerServe>) customerServeDao
				.selectForPage(query, query.initPageBounds());
		Map<String, Object> result = new HashMap<>();
		result.put("rows", customerServes);
		result.put("total", customerServes.getPaginator().getTotalCount());
		return result;
	}

	public void addOrUpdate(CustomerServe customerServe) {
		
		// 基本参数验证
		// TODO
		if(customerServe.getId() == null) {
			customerServeDao.insert(customerServe);
		} else {
			customerServeDao.update(customerServe);
		}
		
		
	}
	
}
