package com.shsxt.crm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.base.BaseController;
import com.shsxt.crm.constant.Constant;
import com.shsxt.crm.model.LinkMan;
import com.shsxt.crm.query.LinkManQuery;
import com.shsxt.crm.service.CustomerService;
import com.shsxt.crm.service.LinkManService;
import com.shsxt.crm.vo.CustomerVo;

@Controller
@RequestMapping("link_man")
public class LinkManController extends BaseController {

	@Autowired
	private LinkManService linkManService;
	@Autowired
	private CustomerService customerService;

	@RequestMapping("index")
	public String index(Integer cusId, Model model) {
		CustomerVo customerVo = customerService.loadById(cusId);
		model.addAttribute("customer", customerVo);
		return "link_man";
	}

	@RequestMapping("list")
	public @ResponseBody Map<String, Object> selectForPage(LinkManQuery query) {
		return linkManService.selectForPage(query);
	}

	@RequestMapping("add_update")
	public @ResponseBody Object addOrUpdate(LinkMan linkMan) {

		linkManService.addOrUpdate(linkMan);
		return success(Constant.OPT_SUCCESS);
	}

	@RequestMapping("delete")
	public @ResponseBody Object delete(Integer id) {
		linkManService.delete(id);
		return success(Constant.OPT_SUCCESS);
	}

}
