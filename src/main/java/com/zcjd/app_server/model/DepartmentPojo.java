package com.zcjd.app_server.model;

import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;

/**
 * 部门，组织机构实体类
 */
public class DepartmentPojo implements Serializable {
	

	private static final long serialVersionUID = 1L;
	//用户简单视图
	public interface DepartmentSimpleView{}
	//用户详细视图（继承用户简单视图）
	public interface DepartmentDetailView extends DepartmentSimpleView{}

	/**数据库标识，主键(UUID)*/
	private String id;
	//父类id
	private String pid;
	//名称
	private String d_name;
	//备注(介绍)
	private String remarks;
	//部门负责人（关联角色表)
	private String userId;
	//联系方式
	private String tel;
	//排序号
	private Integer sort;
	//删除状态（0=未删除，1=已删除;默认值为0）
	private Integer del_state = 0;
	
	//用于前端显示
	private String userName;
	@JsonView(DepartmentDetailView.class)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@JsonView(DepartmentSimpleView.class)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@JsonView(DepartmentSimpleView.class)
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	@JsonView(DepartmentSimpleView.class)
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	@JsonView(DepartmentDetailView.class)
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@JsonView(DepartmentDetailView.class)
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@JsonView(DepartmentDetailView.class)
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@JsonView(DepartmentDetailView.class)
	public Integer getDel_state() {
		return del_state;
	}
	public void setDel_state(Integer del_state) {
		this.del_state = del_state;
	}
	@JsonView(DepartmentDetailView.class)
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		return "DepartmentPojo [id=" + id + ", pid=" + pid + ", d_name=" + d_name + ", remarks=" + remarks + ", userId="
				+ userId + ", tel=" + tel + ", sort=" + sort + ", del_state=" + del_state + ", userName=" + userName
				+ "]";
	}
	
}
