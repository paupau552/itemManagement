package com.demo.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginBean {

	String userId;
	String userPw;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	
}
