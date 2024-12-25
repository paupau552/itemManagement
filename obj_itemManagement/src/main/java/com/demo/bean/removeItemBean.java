package com.demo.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class removeItemBean {
	
	String targetItemname;
	
	public String getTargetItemname() {
		return targetItemname;
	}
	public void setTargetItemname(String targetItemname) {
		this.targetItemname = targetItemname;
	}

}
