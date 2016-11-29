package com.shsxt.crm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.base.BaseController;
import com.shsxt.crm.constant.Constant;
import com.shsxt.crm.model.CustomerServe;
import com.shsxt.crm.query.CustomerServeQuery;
import com.shsxt.crm.service.CustomerServeService;

@RequestMapping("customer_serve")
@Controller
public class CustomerServeController extends BaseController {
	
	@Autowired
	private CustomerServeService customerServeService;

	@RequestMapping("index/{status}")
	public String index(@PathVariable Integer status, Model model) {
		model.addAttribute("status", status);
		switch (status) {
		default:
			return "customer_serve_create";
		case 2:
			return "customer_serve_assign";
		case 3:
			return "customer_serve_handle";
		case 4:
			return "customer_serve_feedback";
		case 5:
			return "customer_serve_archive";
		}
	}
	

    @RequestMapping("list")
    public @ResponseBody
    Map<String, Object> selectForPage(CustomerServeQuery query) {
        return customerServeService.selectForPage(query);
    }

    @RequestMapping("add_update")
    public @ResponseBody Object addOrUpdate(CustomerServe customerServe) {
            customerServeService.addOrUpdate(customerServe);
            return success(Constant.OPT_SUCCESS);
    }
	
	

}
