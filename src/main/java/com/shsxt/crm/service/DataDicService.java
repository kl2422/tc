package com.shsxt.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shsxt.crm.dao.DataDicDao;
import com.shsxt.crm.model.DataDic;

@Service
public class DataDicService {
	
	@Autowired
	private DataDicDao dataDicDao;
	
	/**
	 * 获取所有的客户
	 * @return
	 */
	public List<DataDic> findValueByType(String dataDicName) {
		List<DataDic> dataDicValues = dataDicDao.findValueByType(dataDicName);
		return dataDicValues;
	}
	
}	
