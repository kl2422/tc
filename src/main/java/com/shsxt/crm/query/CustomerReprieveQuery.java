package com.shsxt.crm.query;

import com.shsxt.base.BaseQuery;

/**
 * Created by Tony on 2016/8/25.
 */
@SuppressWarnings("serial")
public class CustomerReprieveQuery extends BaseQuery {
    private Integer lossId;

    public Integer getLossId() {
        return lossId;
    }

    public void setLossId(Integer lossId) {
        this.lossId = lossId;
    }
}
