package com.demo.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoBean {

	String userId;
	String itemName;
	int total;
	int cost;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
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

	
	
}
