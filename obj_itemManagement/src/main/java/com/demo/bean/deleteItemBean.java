package com.demo.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class deleteItemBean {

	String userId;
	String targetItemname;
	
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
}
