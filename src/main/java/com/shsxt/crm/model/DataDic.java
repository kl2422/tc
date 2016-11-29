package com.shsxt.crm.model;

import com.shsxt.base.BaseModel;

/**
 * 数据字典实体
 * Created by Tony on 2016/8/24.
 */
@SuppressWarnings("serial")
public class DataDic extends BaseModel {

    private Integer id; // 编号
    private String dataDicName; // 数据字典名称
    private String dataDicValue; // 数据字典值

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDataDicName() {
        return dataDicName;
    }
    public void setDataDicName(String dataDicName) {
        this.dataDicName = dataDicName;
    }
    public String getDataDicValue() {
        return dataDicValue;
    }
    public void setDataDicValue(String dataDicValue) {
        this.dataDicValue = dataDicValue;
    }
}
