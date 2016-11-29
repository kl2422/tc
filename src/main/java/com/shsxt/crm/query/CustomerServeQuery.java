package com.shsxt.crm.query;

import com.shsxt.base.BaseQuery;
import com.shsxt.crm.constant.CustomerServeStatus;

@SuppressWarnings("serial")
public class CustomerServeQuery extends BaseQuery {
	
	private String customer;
	private String overview;
	private String serveType;
	private Integer state;
	private String createTimefrom;
	private String createTimeto;
	private String stateStr;

	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		setStateStr(CustomerServeStatus.findByStatus(state));
		this.state = state;
	}
	public String getStateStr() {
		return stateStr;
	}
	public void setStateStr(String stateStr) {
		this.stateStr = stateStr;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getServeType() {
		return serveType;
	}
	public void setServeType(String serveType) {
		this.serveType = serveType;
	}
	public String getCreateTimefrom() {
		return createTimefrom;
	}
	public void setCreateTimefrom(String createTimefrom) {
		this.createTimefrom = createTimefrom;
	}
	public String getCreateTimeto() {
		return createTimeto;
	}
	public void setCreateTimeto(String createTimeto) {
		this.createTimeto = createTimeto;
	}
}
