package com.shsxt.crm.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.shsxt.base.exception.ParamException;
import com.shsxt.crm.constant.SaleChanceDevResult;
import com.shsxt.crm.constant.SaleChanceState;
import com.shsxt.crm.dao.SaleChanceDao;
import com.shsxt.crm.model.SaleChance;
import com.shsxt.crm.query.SaleChanceQuery;
import com.shsxt.crm.util.AssertUtil;

@Service
public class SaleChanceService {
	
	@Autowired
	private SaleChanceDao saleChanceDao;
	
	/**
	 * 分页查询
	 * @param query
	 */
	public Map<String, Object> selectForPage(SaleChanceQuery query) {
		
		// 构建查询的分页参数
//		PageBounds pageBounds = new PageBounds(query.getPage(), 
//				query.getLimit(), Order.formString(query.getSort()));
		
		// 分页查询
		List<SaleChance> saleChances = saleChanceDao.selectForPage(query, query.initPageBounds());
		
		//获得结果集
		PageList<SaleChance> pageList = (PageList<SaleChance>)saleChances;
		
		// 构建返回结果
		Map<String, Object> result = new HashMap<>();
		result.put("rows", pageList);
		result.put("total", pageList.getPaginator().getTotalCount()); // 总记录数
		result.put("paginator", pageList.getPaginator());
		return result;
	}
	
	/**
	 * 新增或者修改
	 * @param saleChance
	 */
	public void addOrUpdate(SaleChance saleChance) {
		// 基本参数验证
		Integer customerId = saleChance.getCustomerId();
		if (customerId == null || customerId < 1) {
			throw new ParamException("请选择客户");
		}
		String customerName = saleChance.getCustomerName();
		if (StringUtils.isBlank(customerName)) {
			throw new ParamException("请选择客户");
		}
		int cgjv = saleChance.getCgjl();
		if (cgjv < 1) {
			throw new ParamException("请输入成功几率");
		}
		Integer id= saleChance.getId();
		// 是添加还是修改 根据id判断
		if (id == null || id < 1) { // 如果为空就是添加
			String assginMan = saleChance.getAssignMan();
			if (!StringUtils.isBlank(assginMan)) { // 如果是已经分配好的
				saleChance.setAssignTime(new Date());
				saleChance.setState(SaleChanceState.ASSIGN.getType());
			} else {
				saleChance.setState(SaleChanceState.UN_ASSIGN.getType());
			}
			saleChance.setDevResult(SaleChanceDevResult.UN_DEVELOPE.getType());
			saleChance.setCreateDate(new Date());
			saleChance.setUpdateDate(new Date());
			saleChanceDao.insert(saleChance);
		} else { // 修改
			String assginMan = saleChance.getAssignMan();
			if (!StringUtils.isBlank(assginMan)) { // 如果是已经分配好的
				saleChance.setAssignTime(new Date());
				saleChance.setState(SaleChanceState.ASSIGN.getType());
			}
			saleChance.setUpdateDate(new Date());
			saleChanceDao.update(saleChance);
			
		}
	}
	
	/**
	 * 删除 delete * from 表 where id in (1, 2)
	 * @param ids 多个以逗号分隔 1,2
	 */
	public void delete(String ids) {
		if (StringUtils.isBlank(ids)) {
			throw new ParamException("请选择要删除的记录");
		}
		saleChanceDao.deleteBatch(ids);
	}
	
	/**
	 * 根据id获取到营销机会的内容
	 * @param saleChanceId
	 * @return
	 */
	public SaleChance findById(Integer saleChanceId) {
		AssertUtil.isTrue(saleChanceId == null || saleChanceId < 1, "请选择一条记录进行操作");
		SaleChance saleChance = saleChanceDao.loadById(saleChanceId);
		return saleChance;
	}
	
	/**
	 * 更新开发状态
	 * @param saleChanceId
	 * @param devResult
	 */
	public void updateDevResult(Integer saleChanceId, int devResult) {
		SaleChance saleChance = findById(saleChanceId);
		AssertUtil.isTrue(saleChance == null, "该营销机会不存在。");
		saleChance.setDevResult(devResult);
		saleChanceDao.update(saleChance);
	}
}
