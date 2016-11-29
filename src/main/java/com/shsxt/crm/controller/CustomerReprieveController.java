package com.shsxt.crm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.base.BaseController;
import com.shsxt.crm.constant.Constant;
import com.shsxt.crm.model.CustomerLoss;
import com.shsxt.crm.model.CustomerReprieve;
import com.shsxt.crm.service.CustomerLossService;
import com.shsxt.crm.service.CustomerReprieveService;

@Controller
@RequestMapping("customer_reprieve")
public class CustomerReprieveController extends BaseController {
	
	@Autowired
	private CustomerReprieveService customerReprieveService;
	@Autowired
	private CustomerLossService customerLossService;
	
	@RequestMapping("index")
	public String index(Integer lossId, ModelMap model) {
		model.addAttribute("lossId", lossId);
		CustomerLoss customerLoss = customerLossService.loadById(lossId);
		model.addAttribute("customerLoss", customerLoss);
		
		return "customer_reprieve";
	}

	@RequestMapping("list")
	public @ResponseBody Map<String, Object> selectForPage(Integer lossId) {
		return customerReprieveService.findLossReprieve(lossId);
	}

	@RequestMapping("add_update")
	public @ResponseBody Object addOrUpdate(CustomerReprieve customerReprieve) {
		customerReprieveService.addOrUpdate(customerReprieve);
		return success(Constant.OPT_SUCCESS);
	}

	@RequestMapping("delete")
	public @ResponseBody Object delete(Integer id) {
		customerReprieveService.delete(id);
		return success(Constant.OPT_SUCCESS);
	}
}
