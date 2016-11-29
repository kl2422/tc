package com.shsxt.crm.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shsxt.crm.service.CustomerService;

/**
 * Created by Tony on 2016/8/26.
 */
@Component
public class FindCustomerLossJob {

    @Autowired
    private CustomerService customerService; // 客户Service

    /**
     * 每天凌晨2点定期执行
     */
//    @Scheduled(cron="0 0 2 * * ?")
//    @Scheduled(cron="0/1 * * * * ?")
    public void work() {
        System.out.println("定时任务开始...");
        customerService.initAddCustomerLoss();
    }

}
