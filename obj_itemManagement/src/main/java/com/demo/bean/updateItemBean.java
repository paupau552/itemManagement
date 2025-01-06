package com.demo.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class updateItemBean {

	String userId;
	String targetItemname;
	int total;
	int cost;
	int auth;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTargetItemname() {
		return targetItemname;
	}
	public void setTargetItemname(String targetItemname) {
		this.targetItemname = targetItemname;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getAuth() {
		return auth;
	}
	public void setAuth(int auth) {
		this.auth = auth;
	}
	
}
