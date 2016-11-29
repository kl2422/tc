package com.shsxt.crm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.base.BaseController;
import com.shsxt.base.exception.ParamException;
import com.shsxt.crm.constant.Constant;
import com.shsxt.crm.model.CustomerLoss;
import com.shsxt.crm.query.CustomerLossQuery;
import com.shsxt.crm.service.CustomerLossService;

/**
 * Created by Tony on 2016/8/24.
 */
@Controller
@RequestMapping("customer_loss")
public class CustomerLossController extends BaseController {

    @Autowired
    private CustomerLossService customerLossService;

    @RequestMapping("index")
    public String index() {
        return "customer_loss";
    }

    @RequestMapping("list")
    public @ResponseBody Map<String, Object> selectForPage(CustomerLossQuery customerLossQuery) {
        return customerLossService.selectForPage(customerLossQuery);
    }

    @RequestMapping("confirmLoss")
    public @ResponseBody Object confirmLoss(Integer lossId, String lossReason) {
        try {
            customerLossService.confirmLoss(lossId, lossReason);
            return success(Constant.OPT_SUCCESS);
        } catch (ParamException e) {
            return failure(e.getMessage());
        }
    }

    @RequestMapping("detail")
    public @ResponseBody Object loadById(Integer id) {
        try {
            CustomerLoss customerLoss = customerLossService.loadById(id);
            return customerLoss;
        } catch (ParamException e) {
            return failure(e.getMessage());
        }
    }
}
