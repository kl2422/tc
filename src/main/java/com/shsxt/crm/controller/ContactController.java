package com.shsxt.crm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.base.BaseController;
import com.shsxt.base.ResultInfo;
import com.shsxt.crm.constant.Constant;
import com.shsxt.crm.model.Contact;
import com.shsxt.crm.query.LinkManQuery;
import com.shsxt.crm.service.ContactService;
import com.shsxt.crm.service.CustomerService;
import com.shsxt.crm.vo.CustomerVo;

/**
 * Created by Tony on 2016/8/24.
 */
@Controller
@RequestMapping("contact")
public class ContactController extends BaseController {

	@Autowired
	private ContactService contactService;
	@Autowired
	private CustomerService customerService;

	@RequestMapping("index")
	public String index(Integer cusId, ModelMap model) {
		CustomerVo customerVo = customerService.loadById(cusId);
		model.addAttribute("customer", customerVo);
		return "contact";
	}

	@RequestMapping("list")
	public @ResponseBody Map<String, Object> selectForPage(LinkManQuery linkManQuery) {
		return contactService.selectForPage(linkManQuery);
	}

	@RequestMapping("add_update")
	public @ResponseBody ResultInfo addOrUpdate(Contact contact) {
		contactService.addOrUpdate(contact);
		return success(Constant.OPT_SUCCESS);

	}

	@RequestMapping("delete")
	public @ResponseBody ResultInfo delete(Integer id) {
		contactService.delete(id);
		return success(Constant.OPT_SUCCESS);
	}
}
