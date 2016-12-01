package com.shsxt.crm.query;

import com.shsxt.base.BaseQuery;

/**
 * Created by Tony on 2016/8/26.
 */
@SuppressWarnings("serial")
public class CustomerGxQuery extends BaseQuery {

    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
