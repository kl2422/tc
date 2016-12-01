package com.shsxt.crm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.base.BaseController;
import com.shsxt.crm.model.CustomerFw;
import com.shsxt.crm.model.CustomerGc;
import com.shsxt.crm.query.CustomerGxQuery;
import com.shsxt.crm.service.CustomerService;

@RequestMapping("report")
@Controller
public class ReportController extends BaseController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("{type}")
    public String index(@PathVariable(value="type") Integer pageType) {
        switch (pageType) {
            default:
                return "khgxfx";
            case 1:
                return "khgcfx";
            case 2:
                return "khfwfx";
            case 3:
                return "khlsfx";
        }
    }
	
    /**
     * 客户构成分析
     * @return
     */
    @RequestMapping("khgcfx")
    public @ResponseBody List<CustomerGc> findCustomerGc() {
        List<CustomerGc> customerGcs = customerService.findCustomerGc();
        return customerGcs;

    }
    
    /**
     * 客户贡献分析
     * @param customerGxQuery
     * @return
     */
    @RequestMapping("fhgxfx")
    public @ResponseBody Map<String, Object> findCustomerGx(CustomerGxQuery customerGxQuery) {
        Map<String, Object> result = customerService.findCustomerGx(customerGxQuery);
        return result;
    }

    /**
     * 客户服务分析
     * @return
     */
    @RequestMapping("khfwfx")
    public @ResponseBody List<CustomerFw> findCustomerFw() {
        List<CustomerFw> customerFws = customerService.findCustomerFw();
        return customerFws;
    }
	
	
}
