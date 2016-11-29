package com.shsxt.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.model.DataDic;

public interface DataDicDao extends BaseDao<DataDic> {
	
	@Select("select dataDicValue from t_datadic where dataDicName = #{dataDicName} and isValid = 1")
	public List<DataDic> findValueByType(@Param(value = "dataDicName") String dataDicName);
	
}
