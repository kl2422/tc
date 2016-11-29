package com.shsxt.crm.dao;

import org.springframework.stereotype.Repository;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.model.Order;

/**
 * Created by Tony on 2016/8/24.
 */

@Repository
public interface OrderDao extends BaseDao<Order> {

    public Order findLastOrderByCusId(Integer cusId);

}
