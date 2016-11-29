package com.shsxt.crm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.base.BaseController;
import com.shsxt.base.ResultInfo;
import com.shsxt.crm.constant.Constant;
import com.shsxt.crm.model.Customer;
import com.shsxt.crm.query.CustomerQuery;
import com.shsxt.crm.service.CustomerService;
import com.shsxt.crm.vo.CustomerVo;

@Controller
@RequestMapping("customer")
public class CustomerController extends BaseController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("find_all")
	@ResponseBody
	public List<CustomerVo> findAll () {
		return customerService.findAll();
	}
	
	@RequestMapping("index")
	public String index() {
		return "customer";
	}
	
	@RequestMapping("list")
	@ResponseBody
	public Map<String, Object>selectForPage(CustomerQuery query) {
		Map<String, Object> result = customerService.selectForPage(query);
		return result;
	}
	
	@RequestMapping("add_update")
	@ResponseBody
	public ResultInfo addOrUpdate(Customer customer) {
		customerService.addOrUpdate(customer);
		return success(Constant.OPT_SUCCESS);
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public ResultInfo delete(String ids) {
		customerService.delete(ids);
		return success(Constant.OPT_SUCCESS);
	}
	
}
