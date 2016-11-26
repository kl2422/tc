package com.shsxt.crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.base.BaseController;
import com.shsxt.base.ResultInfo;
import com.shsxt.base.exception.ParamException;
import com.shsxt.crm.constant.Constant;
import com.shsxt.crm.model.User;
import com.shsxt.crm.service.UserService;
import com.shsxt.crm.util.LoginUserUtil;
import com.shsxt.crm.vo.UserLoginIdentity;

@Controller
@RequestMapping("user")
public class UserController extends BaseController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("list")
	public String listAll(Model model) {
		List<User> users = userService.listAll();
		model.addAttribute("users", users);
		return "user_list";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public ResultInfo login(String userName, String password, String roleName) {
		try {
			UserLoginIdentity result = userService.login(userName, password, roleName);
			return success(result);
		} catch (ParamException e) {
			return failure(e.getMessage());
		}
		
	}
	
	@RequestMapping(value = "update_password")
	@ResponseBody
	public ResultInfo updatePassword(String oldPassword, String newPassword, 
			String confirmPassword, HttpServletRequest request) {
		try {
			Integer userId = LoginUserUtil.loadUserIdFromCookie(request);
			userService.updatePassword(oldPassword, newPassword, 
					confirmPassword, userId);
			return success(Constant.OPT_SUCCESS);
		} catch (ParamException e) {
			return failure(e.getMessage());
		}
		
	}
	
	@RequestMapping("find_customer_manager")
	@ResponseBody
	public List<User> findCustomerManager() {
		List<User> customerManagers = userService.findCustomerManagers();
		return customerManagers;
		
	}
	
}
