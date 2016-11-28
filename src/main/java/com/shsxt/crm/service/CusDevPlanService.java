package com.shsxt.crm.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shsxt.crm.constant.SaleChanceDevResult;
import com.shsxt.crm.dao.CusDevPlanDao;
import com.shsxt.crm.model.CusDevPlan;
import com.shsxt.crm.util.AssertUtil;

@Service
public class CusDevPlanService {
	
	@Autowired
	private CusDevPlanDao cusDevPlanDao;
	@Autowired
	private SaleChanceService saleChanceService;
	
	/**
	 * 查询营销机会下的所有的开发项
	 * @param saleChanceId
	 * @return
	 */
	public Map<String, List<CusDevPlan>> find(Integer saleChanceId) {
		AssertUtil.isTrue(saleChanceId == null || saleChanceId < 1, "请选择一条记录进行操作");
		Map<String, Object> param = new HashMap<>();
		param.put("saleChanceId", saleChanceId);
		List<CusDevPlan> cusDevPlans = cusDevPlanDao.find(param);
		Map<String, List<CusDevPlan>> result = new HashMap<>();
		result.put("rows", cusDevPlans);
		return result;
	}
	
	/**
	 * 添加或者修改开发项
	 * @param cusDevPlan
	 */
	public void addOrUpdate(CusDevPlan cusDevPlan) {
		
		// 参数验证
		Date planDate = cusDevPlan.getPlanDate();
		AssertUtil.isTrue(planDate == null, "请输入日期");
		String planItem = cusDevPlan.getPlanItem();
		AssertUtil.notEmpty(planItem, "请输入计划内容");
		String exeAffect = cusDevPlan.getExeAffect();
		AssertUtil.notEmpty(exeAffect, "请输入执行效果");
		
		// 判断是否新增还是修改
		Integer id = cusDevPlan.getId();
		if (id == null) { // 新增 注意修改营销机会的开发状态为开发中
			cusDevPlanDao.insert(cusDevPlan);
			// 修改营销机会的开发状态
			saleChanceService.updateDevResult(cusDevPlan.getSaleChanceId(), 
					SaleChanceDevResult.DEVELOPING.getType());
			
		} else { // 修改
			cusDevPlanDao.update(cusDevPlan);
		}
		
	}
	
	/**
	 * 删除开发项
	 * @param id
	 */
	public void delete(Integer id) {
		AssertUtil.isTrue(id == null || id < 1, "请选择一条记录进行删除");
		cusDevPlanDao.delete(id);
	}
	
	
	
}
