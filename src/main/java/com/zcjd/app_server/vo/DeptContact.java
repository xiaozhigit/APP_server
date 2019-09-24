package com.zcjd.app_server.vo;



import com.zcjd.app_server.model.DepartmentPojo;
import com.zcjd.app_server.model.UserInfoPojo;

import java.util.List;

@SuppressWarnings("serial")
public class DeptContact extends DepartmentPojo {
	//部门下的联系人
	private List<UserInfoPojo>     userInfos;
	 
	public List<UserInfoPojo> getUserInfos() {
		return userInfos;
	}
	public void setUserInfos(List<UserInfoPojo> userInfos) {
		this.userInfos = userInfos;
	}
	 
}
