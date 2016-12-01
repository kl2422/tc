package com.shsxt.crm.mongodb;

import java.io.Serializable;

@SuppressWarnings("serial")
public class OperationLog implements Serializable {
	
	private String module;
	private String desc;
	private Integer optUserId;
	private String optUserName;
	private String method;
	private Object[] args;
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Integer getOptUserId() {
		return optUserId;
	}
	public void setOptUserId(Integer optUserId) {
		this.optUserId = optUserId;
	}
	public String getOptUserName() {
		return optUserName;
	}
	public void setOptUserName(String optUserName) {
		this.optUserName = optUserName;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public Object[] getArgs() {
		return args;
	}
	public void setArgs(Object[] args) {
		this.args = args;
	}
}
