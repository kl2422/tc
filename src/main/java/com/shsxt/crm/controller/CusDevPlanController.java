package com.shsxt.crm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shsxt.base.BaseController;
import com.shsxt.base.ResultInfo;
import com.shsxt.crm.constant.Constant;
import com.shsxt.crm.model.CusDevPlan;
import com.shsxt.crm.service.CusDevPlanService;

@RestController
@RequestMapping("cus_dev_plan")
public class CusDevPlanController extends BaseController {
	
	@Autowired
	private CusDevPlanService cusDevPlanService;
	
//	@InitBinder
//    public void initBinder(WebDataBinder binder) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        dateFormat.setLenient(false);
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值
//    }

	
	@RequestMapping("list")
	public Map<String, List<CusDevPlan>> find(Integer saleChanceId) {
		Map<String, List<CusDevPlan>> result = cusDevPlanService.find(saleChanceId);
		return result;
	}
	
//	@RequestMapping("add_update")
//	public ResultInfo addOrUpdate(CusDevPlan cusDevPlan, 
//			BindingResult bindingResult, HttpServletRequest req) {
//		List<ObjectError> allErrors = bindingResult.getAllErrors();
//		for (ObjectError objectError : allErrors) {
//			System.out.println(objectError.toString());
//		}
//		
//		if (bindingResult.hasFieldErrors("planDate")) {
//			String planDateStr = req.getParameter("planDate");
//			Date planDate = DateUtil.parseDatetime(planDateStr);
//			cusDevPlan.setPlanDate(planDate);
//		}
//		
//		cusDevPlanService.addOrUpdate(cusDevPlan);
//		return success(Constant.OPT_SUCCESS);
//	}
	
	@RequestMapping("add_update")
	public ResultInfo addOrUpdate(CusDevPlan cusDevPlan) {
		cusDevPlanService.addOrUpdate(cusDevPlan);
		return success(Constant.OPT_SUCCESS);
	}
	
	
	
	@RequestMapping("delete")
	public ResultInfo delete(Integer id) {
		cusDevPlanService.delete(id);
		return success(Constant.OPT_SUCCESS);
	}
	
	
}
