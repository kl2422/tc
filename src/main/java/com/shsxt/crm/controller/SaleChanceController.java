package com.shsxt.crm.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.base.BaseController;
import com.shsxt.base.ResultInfo;
import com.shsxt.base.exception.ParamException;
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
	public String index(HttpServletRequest request, Model model) {
		return "sale_chance";
	}
	
	@RequestMapping("list")
	@ResponseBody
	public Map<String, Object> selectForPage(SaleChanceQuery query) {
		Map<String, Object> result = saleChanceService.selectForPage(query);
		return result;
	}
	
	@RequestMapping("add_update")
	@ResponseBody
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
	
}
