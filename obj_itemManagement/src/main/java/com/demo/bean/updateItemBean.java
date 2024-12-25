package com.demo.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class updateItemBean {

	String userId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
