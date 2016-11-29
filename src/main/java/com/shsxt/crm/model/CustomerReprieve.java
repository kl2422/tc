package com.shsxt.crm.model;

import com.shsxt.base.BaseModel;

/**
 * Created by Tony on 2016/8/25.
 */
@SuppressWarnings("serial")
public class CustomerReprieve extends BaseModel {

    private Integer id; // 编号
    private Integer lossId; // 客户流失
    private String measure; // 暂缓措施

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLossId() {
        return lossId;
    }

    public void setLossId(Integer lossId) {
        this.lossId = lossId;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }
}
