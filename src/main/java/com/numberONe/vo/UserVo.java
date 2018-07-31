package com.numberONe.vo;

import java.io.Serializable;

import com.numberONe.po.UserPo;


public class UserVo extends UserPo  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String custName;

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	
	
	

}
