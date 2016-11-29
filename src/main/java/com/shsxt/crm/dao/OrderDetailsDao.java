package com.shsxt.crm.dao;

import org.springframework.stereotype.Repository;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.model.OrderDetails;

/**
 * Created by Tony on 2016/8/24.
 */

@Repository
public interface OrderDetailsDao extends BaseDao<OrderDetails> {

    /**
     * 获取订单总金额
     * @param orderId
     * @return
     */
    public Float getTotalPriceByOrderId(Integer orderId);

}
