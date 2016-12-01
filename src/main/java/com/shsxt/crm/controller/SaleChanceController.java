package com.shsxt.crm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.base.BaseController;
import com.shsxt.base.ResultInfo;
import com.shsxt.base.exception.ParamException;
import com.shsxt.crm.annotation.OptLog;
import com.shsxt.crm.constant.Constant;
import com.shsxt.crm.model.SaleChance;
import com.shsxt.crm.query.SaleChanceQuery;
import com.shsxt.crm.service.SaleChanceService;

@Controller
@RequestMapping("sale_chance")
public class SaleChanceController extends BaseController {
	
	@Autowired
	private SaleChanceService saleChanceService;
	
	@RequestMapping("index")
	public String index(Integer state) {
		if (state == null) {
			return "sale_chance";
		} else {
			return "customer_dev";
		}
	}
	
	@RequestMapping("list")
	@ResponseBody
	@OptLog(module="营销管理-营销机会管理", desc="读取数据")
	public Map<String, Object> selectForPage(SaleChanceQuery query) {
		Map<String, Object> result = saleChanceService.selectForPage(query);
		return result;
	}
	
	@RequestMapping("add_update")
	@ResponseBody
	@OptLog(module="营销管理-营销机会管理", desc="新增或修改数据")
	public ResultInfo addOrUpdate(SaleChance saleChance) {
		try {
			saleChanceService.addOrUpdate(saleChance);
			return success(Constant.OPT_SUCCESS);
		} catch (ParamException e) {
//			return new ResultInfo(e.getMessage());
			return failure(e.getMessage());
		}
		
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public ResultInfo delete(String ids) {
		try {
			saleChanceService.delete(ids);
//			return new ResultInfo(Constant.OPT_SUCCESS);
			return success(Constant.OPT_SUCCESS);
		} catch (ParamException e) {
//			return new ResultInfo(e.getMessage());
			return failure(e.getMessage());
		}
	}
	
	/**
	 * 跳转到开发计划项
	 * @return
	 */
	@RequestMapping("detail")
	public String findDetail(Integer saleChanceId, Integer show, Model model) {
		
		SaleChance saleChance = saleChanceService.findById(saleChanceId);
		model.addAttribute("saleChance", saleChance);
		model.addAttribute("saleChanceId", saleChanceId);
		model.addAttribute("show", show);
		return "customer_dev_detail";
	}
	
	@RequestMapping("update_devresult")
	@ResponseBody
	public ResultInfo dateDevresult(Integer id, Integer devResult) {
		saleChanceService.updateDevResult(id, devResult);
		return success(Constant.OPT_SUCCESS);
	}
	
}
