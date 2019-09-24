package com.zcjd.app_server.model;

import java.io.Serializable;

/**
 * 由于人员实体类的字段太多
 * 故新建此实体类
 * 用于人员树的数据获取
 * @author Administrator
 *
 */
public class UserTreePojo implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 数据库标识ID */
	private String id;
	/** 部门id */
	private String deptId;
	/** 人员名称 */
	private String u_name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	
}
