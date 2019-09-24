package com.zcjd.app_server.model;

import java.io.Serializable;

/**
 * 用于账号管理的展示
 * @author gaojun
 *
 */
public class UserInfoAccountPojo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String userInfoId;			//hr_user_info的id
	private String account;				//账号
	private String passward;			//密码
	private String userName;			//姓名
	private String userDept;			//所在部门
	private String userRoles;			//角色
	private String accountType;			//启用/停用
	private String createTime;			//创建时间
	
	public String getUserInfoId() {
		return userInfoId;
	}
	public void setUserInfoId(String userInfoId) {
		this.userInfoId = userInfoId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassward() {
		return passward;
	}
	public void setPassward(String passward) {
		this.passward = passward;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserDept() {
		return userDept;
	}
	public void setUserDept(String userDept) {
		this.userDept = userDept;
	}
	public String getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(String userRoles) {
		this.userRoles = userRoles;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
