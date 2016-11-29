package com.shsxt.crm.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shsxt.base.BaseModel;

/**
 * Created by Tony on 2016/8/24.
 */
@SuppressWarnings("serial")
public class Contact extends BaseModel {

    private Integer id; // 编号
    private Integer cusId; // 所属客户
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date contactTime; // 交往时间
    private String address; // 交往地点
    private String overview; // 概要

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    public Date getContactTime() {
        return contactTime;
    }

    public void setContactTime(Date contactTime) {
        this.contactTime = contactTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}
}
