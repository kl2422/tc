package com.shsxt.crm.dao;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.shsxt.base.BaseDao;
import com.shsxt.crm.model.CustomerReprieve;

public interface CustomerReprieveDao extends BaseDao<CustomerReprieve> {

	PageList<CustomerReprieve> findLossReprieve(@Param(value="lossId") Integer lossId);

}
