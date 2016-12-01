package com.shsxt.crm.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.shsxt.crm.dao.CustomerDao;
import com.shsxt.crm.dao.CustomerLossDao;
import com.shsxt.crm.dao.OrderDao;
import com.shsxt.crm.model.Customer;
import com.shsxt.crm.model.CustomerFw;
import com.shsxt.crm.model.CustomerGc;
import com.shsxt.crm.model.CustomerGx;
import com.shsxt.crm.model.CustomerLoss;
import com.shsxt.crm.model.Order;
import com.shsxt.crm.query.CustomerGxQuery;
import com.shsxt.crm.query.CustomerQuery;
import com.shsxt.crm.util.AssertUtil;
import com.shsxt.crm.util.MathUtil;
import com.shsxt.crm.vo.CustomerVo;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private CustomerLossDao customerLossDao;
	@Autowired
	private OrderDao orderDao;
	
	/**
	 * 获取所有的客户
	 * @return
	 */
	public List<CustomerVo> findAll() {
		List<CustomerVo> customerVos = customerDao.listAll();
		return customerVos;
	}
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	public Map<String, Object> selectForPage(CustomerQuery query) {
		if (StringUtils.isBlank(query.getSort())) {
			query.setSort("id.desc");
		}
		
		PageList<Customer> customers = (PageList<Customer>) customerDao
				.selectForPage(query, query.initPageBounds());
		Map<String, Object> result = new HashMap<>();
		result.put("rows", customers);
		result.put("total", customers.getPaginator().getTotalCount());
		result.put("paginator", customers.getPaginator()); // 这里只负责展示看看
		return result;
	}

	public void addOrUpdate(Customer customer) {
		// TODO 参数验证
		// 根据ID判断是新增还是修改
		Integer id = customer.getId();
        if (id == null) { // 新增
            customer.setKhno(MathUtil.genereateKhCode()); // 生成自动客户编号
            customerDao.insert(customer);
        } else {
            customerDao.update(customer);
        }
	}
	
	/**
	 * 删除
	 * @param ids
	 */
	public void delete(String ids) {
		AssertUtil.notEmpty(ids, "请选中要删除的记录");
		customerDao.deleteBatch(ids);
	}
	
	/**
	 * 获取客户基本信息
	 * @param cusId
	 * @return
	 */
	public CustomerVo loadById(Integer cusId) {
		AssertUtil.isTrue(cusId == null || cusId < 1, "请选中客户");
		CustomerVo customerVo = customerDao.findVoById(cusId);
		return customerVo;
	}

	public void initAddCustomerLoss() {
		// 第一步: 查询添加客户后六个月都没有订单的客户
        List<Customer> customerNoOrders = customerDao.findNoOrdersCustomer();
        // 第二步: 下单后六个月再也没有下单的客户
        List<Customer> $customerNoOrders = customerDao.findLossCustomer();

        Set<Customer> customerSet = new HashSet<>();
        if (customerNoOrders != null && customerNoOrders.size() > 0) {
            customerSet.addAll(customerNoOrders);
        }
        if ($customerNoOrders != null && $customerNoOrders.size() > 0) {
            customerSet.addAll($customerNoOrders);
        }

        for(Customer customer: customerSet) {
            CustomerLoss customerLoss = new CustomerLoss(); // 实例化客户流失实体
            customerLoss.setCusNo(customer.getKhno()); // 客户编号
            customerLoss.setCusName(customer.getName()); // 客户名称
            customerLoss.setCusManager(customer.getCusManager()); // 客户经理
            Order order = orderDao.findLastOrderByCusId(customer.getId()); // 查找指定客户最近的订单
            if(order == null) {
                customerLoss.setLastOrderTime(null);
            }else{
                customerLoss.setLastOrderTime(order.getOrderDate()); // 设置最近的下单日期
            }
            customerLossDao.insert(customerLoss); // 添加到客户流失表
            customer.setState(1); // 客户状态修改成1 流失状态
            customerDao.update(customer);
        }
	}
	
	/**
     * 分页查询用户的贡献值
     * @param customerGxQuery
     * @return
     */
    public Map<String, Object> findCustomerGx(CustomerGxQuery customerGxQuery) {

        PageList<CustomerGx> customerGxes = (PageList<CustomerGx>) customerDao.findCustomerGx(customerGxQuery,
                customerGxQuery.initPageBounds());
        Map<String, Object> result = new HashMap<>();
        result.put("rows", customerGxes);
        result.put("total", customerGxes.getPaginator().getTotalCount());
        return result;
    }
    
    /**
     * 查询所有正常的客户
     * @return
     */
	public List<Customer> findNormalCustomer() {
		return customerDao.findNormalCustomer();
	}
    
    /**
     * 查询客户构成信息
     * @return
     */
    public List<CustomerGc> findCustomerGc() {
        return customerDao.findCustomerGc();
    }

    /**
     * 查询客户服务信息
     * @return
     */
    public List<CustomerFw> findCustomerFw() {
        return customerDao.findCustomerFw();
    }
	
}	
