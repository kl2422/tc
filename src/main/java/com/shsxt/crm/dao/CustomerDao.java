package com.shsxt.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.shsxt.base.BaseDao;
import com.shsxt.crm.model.Customer;
import com.shsxt.crm.model.CustomerFw;
import com.shsxt.crm.model.CustomerGc;
import com.shsxt.crm.model.CustomerGx;
import com.shsxt.crm.query.CustomerGxQuery;
import com.shsxt.crm.vo.CustomerVo;

public interface CustomerDao extends BaseDao<Customer> {

	@Select("select id, name from t_customer where isValid = 1 and state = 0 ")
	public List<CustomerVo> listAll();
	
	@Select("select id, name, khno as customerNo from t_customer where id = #{cusId}")
	public CustomerVo findVoById(@Param(value="cusId") Integer cusId);

	
	public List<Customer> findNoOrdersCustomer();

	public List<Customer> findLossCustomer();
	
	/**
	 * 客户构成分析
	 * @return
	 */
	public List<CustomerGc> findCustomerGc();
	
	/**
     * 查询客户贡献记录数
     * @param customerGxQuery
     * @param pageBounds
     * @return
     */
    public List<CustomerGx> findCustomerGx(CustomerGxQuery customerGxQuery, PageBounds pageBounds);

    /**
     * 查询客户服务分析
     * @return
     */
    public List<CustomerFw> findCustomerFw();

    
    /**
     * 获取正常的客户
     * @return
     */
	public List<Customer> findNormalCustomer();
	
	

}
