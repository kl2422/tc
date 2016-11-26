package com.shsxt.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.shsxt.crm.vo.CustomerVo;

public interface CustomerDao {

	@Select("select id, name from t_customer where isValid = 1 and state = 0 ")
	public List<CustomerVo> listAll();
	
	

}
