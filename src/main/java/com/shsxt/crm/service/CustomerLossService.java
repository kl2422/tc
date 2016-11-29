package com.shsxt.crm.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.shsxt.crm.dao.CustomerLossDao;
import com.shsxt.crm.model.CustomerLoss;
import com.shsxt.crm.query.CustomerLossQuery;
import com.shsxt.crm.util.AssertUtil;

/**
 * Created by Tony on 2016/8/24.
 */
@Service
public class CustomerLossService {

    @Autowired
    private CustomerLossDao customerLossDao;
    
    /**
     * 分页查询
     * @param customerLossQuery
     * @return
     */
	public Map<String, Object> selectForPage(CustomerLossQuery query) {
		PageList<CustomerLoss> customers = (PageList<CustomerLoss>) customerLossDao
				.selectForPage(query, query.initPageBounds());
		Map<String, Object> result = new HashMap<>();
		result.put("rows", customers);
		result.put("total", customers.getPaginator().getTotalCount());
		return result;
	}

    /**
     * 确认流失
     * @param lossId
     * @param lossReason
     */
    public void confirmLoss(Integer lossId, String lossReason) {
        AssertUtil.isTrue(lossId == null || lossId < 1, "请选择流失记录");
        AssertUtil.notEmpty(lossReason, "请输入流失原因");
        CustomerLoss customerLoss = customerLossDao.loadById(lossId);
        AssertUtil.notNull(customerLoss, "该客户并没有流失， 请确定");
        customerLoss.setLossReason(lossReason);
        customerLoss.setState(1);
        customerLossDao.update(customerLoss);
    }
    
    /**
     * 通过主键获取记录
     * @param id
     * @return
     */
	public CustomerLoss loadById(Integer id) {
		AssertUtil.isTrue(id == null || id < 1, "请选择流失记录");
		CustomerLoss customerLoss = customerLossDao.loadById(id);	
		return customerLoss;
	}
}