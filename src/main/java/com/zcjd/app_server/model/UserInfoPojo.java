package com.zcjd.app_server.model;

import java.io.Serializable;


//人事信息hr_user-info
public class UserInfoPojo implements Serializable {

	private static final long serialVersionUID = 1L;
	 //数据库标识，主键(UUID) 
	private String id;
    //用户名
	private String u_name;
	//性别（1=男、 0=女）
	private String u_sex;
	//出生日期
	private String u_birthday;
	//工号
	private String u_number;
	//工号类型(默认为0，不允许修改，超级管理员admin的该值为-1，其余为0)
	private Integer u_num_type = 0;
	//婚姻状态（1=已婚、0=未婚）
	private String u_married;
	//民族
	private String u_nation;
	//身份证号
	private String u_card;
	//国籍
	private String u_nationality;
	//政治面貌
	private String u_identity;
	//户籍所在地
	private String u_birthplace;
	//现居住地
	private String u_address;
	//最高学历
	private String u_education;
	//毕业时间
	private String u_gradu_time;
	//参加工作时间
	private String u_work_time;
	//所在部门Id
	private String deptId;
	//员工类型
	private String u_type;
	//员工级别
	private String u_level;
	//职称
	private String u_technical;
	//职位
	private String u_job;
	//入职时间
	private String u_entry_time;
	//转正时间
	private String u_regular_time;
	//工作电话
	private String u_tel;
	//手机
	private String u_phone;
	//电子邮箱
	private String u_email;
	//QQ
	private String u_qq;
	//备注
	private String u_remarks;
	//创建人
	private String create_id;
	//创建时间
	private String create_time;
	//删除状态 0=未删除 1=删除
	private Integer del_state=0;
	//离职状态 0=未离职 1= 已离职
	private String lz_state;
	//离职时间
	private String lz_time;
	//离职类型
	private String lz_type;
	//离职备注
	private String lz_remarks;
	//账号状态（0正常，1未正常启用）
	private Integer u_count;
	//密码
	private String password;
	//图片二进制
	private String picdata;
	//部门名称
	private String deptName; 
	//职位名称
	private String jobName;
	

	

	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getPicdata() {
		return picdata;
	}
	public void setPicdata(String picdata) {
		this.picdata = picdata;
	}
	public Integer getU_count() {
		return u_count;
	}
	public void setU_count(Integer u_count) {
		this.u_count = u_count;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_sex() {
		return u_sex;
	}
	public void setU_sex(String u_sex) {
		this.u_sex = u_sex;
	}
	public String getU_birthday() {
		return u_birthday;
	}
	public void setU_birthday(String u_birthday) {
		this.u_birthday = u_birthday;
	}
	public String getU_number() {
		return u_number;
	}
	public void setU_number(String u_number) {
		this.u_number = u_number;
	}
	public String getU_married() {
		return u_married;
	}
	public void setU_married(String u_married) {
		this.u_married = u_married;
	}
	public String getU_nation() {
		return u_nation;
	}
	public void setU_nation(String u_nation) {
		this.u_nation = u_nation;
	}
	public String getU_card() {
		return u_card;
	}
	public void setU_card(String u_card) {
		this.u_card = u_card;
	}
	public String getU_nationality() {
		return u_nationality;
	}
	public void setU_nationality(String u_nationality) {
		this.u_nationality = u_nationality;
	}
	public String getU_identity() {
		return u_identity;
	}
	public void setU_identity(String u_identity) {
		this.u_identity = u_identity;
	}
	public String getU_birthplace() {
		return u_birthplace;
	}
	public void setU_birthplace(String u_birthplace) {
		this.u_birthplace = u_birthplace;
	}
	public String getU_address() {
		return u_address;
	}
	public void setU_address(String u_address) {
		this.u_address = u_address;
	}
	public String getU_education() {
		return u_education;
	}
	public void setU_education(String u_education) {
		this.u_education = u_education;
	}
	public String getU_gradu_time() {
		return u_gradu_time;
	}
	public void setU_gradu_time(String u_gradu_time) {
		this.u_gradu_time = u_gradu_time;
	}
	public String getU_work_time() {
		return u_work_time;
	}
	public void setU_work_time(String u_work_time) {
		this.u_work_time = u_work_time;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getU_type() {
		return u_type;
	}
	public void setU_type(String u_type) {
		this.u_type = u_type;
	}
	public String getU_level() {
		return u_level;
	}
	public void setU_level(String u_level) {
		this.u_level = u_level;
	}
	public String getU_technical() {
		return u_technical;
	}
	public void setU_technical(String u_technical) {
		this.u_technical = u_technical;
	}
	public String getU_job() {
		return u_job;
	}
	public void setU_job(String u_job) {
		this.u_job = u_job;
	}
	public String getU_entry_time() {
		return u_entry_time;
	}
	public void setU_entry_time(String u_entry_time) {
		this.u_entry_time = u_entry_time;
	}
	public String getU_regular_time() {
		return u_regular_time;
	}
	public void setU_regular_time(String u_regular_time) {
		this.u_regular_time = u_regular_time;
	}
	public String getU_tel() {
		return u_tel;
	}
	public void setU_tel(String u_tel) {
		this.u_tel = u_tel;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public String getU_qq() {
		return u_qq;
	}
	public void setU_qq(String u_qq) {
		this.u_qq = u_qq;
	}
	public String getU_remarks() {
		return u_remarks;
	}
	public void setU_remarks(String u_remarks) {
		this.u_remarks = u_remarks;
	}
	public String getCreate_id() {
		return create_id;
	}
	public void setCreate_id(String create_id) {
		this.create_id = create_id;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public Integer getDel_state() {
		return del_state;
	}
	public void setDel_state(Integer del_state) {
		this.del_state = del_state;
	}
	public String getLz_state() {
		return lz_state;
	}
	public void setLz_state(String lz_state) {
		this.lz_state = lz_state;
	}
	public String getLz_time() {
		return lz_time;
	}
	public void setLz_time(String lz_time) {
		this.lz_time = lz_time;
	}
	public String getLz_type() {
		return lz_type;
	}
	public void setLz_type(String lz_type) {
		this.lz_type = lz_type;
	}
	public String getLz_remarks() {
		return lz_remarks;
	}
	public void setLz_remarks(String lz_remarks) {
		this.lz_remarks = lz_remarks;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getU_num_type() {
		return u_num_type;
	}
	public void setU_num_type(Integer u_num_type) {
		this.u_num_type = u_num_type;
	}
	
	@Override
	public String toString() {
		return "UserInfoPojo [id=" + id + ", u_name=" + u_name + ", u_sex=" + u_sex + ", u_birthday=" + u_birthday
				+ ", u_number=" + u_number + ", u_num_type=" + u_num_type + ", u_married=" + u_married + ", u_nation="
				+ u_nation + ", u_card=" + u_card + ", u_nationality=" + u_nationality + ", u_identity=" + u_identity
				+ ", u_birthplace=" + u_birthplace + ", u_address=" + u_address + ", u_education=" + u_education
				+ ", u_gradu_time=" + u_gradu_time + ", u_work_time=" + u_work_time + ", deptId=" + deptId + ", u_type="
				+ u_type + ", u_level=" + u_level + ", u_technical=" + u_technical + ", u_job=" + u_job
				+ ", u_entry_time=" + u_entry_time + ", u_regular_time=" + u_regular_time + ", u_tel=" + u_tel
				+ ", u_phone=" + u_phone + ", u_email=" + u_email + ", u_qq=" + u_qq + ", u_remarks=" + u_remarks
				+ ", create_id=" + create_id + ", create_time=" + create_time + ", del_state=" + del_state
				+ ", lz_state=" + lz_state + ", lz_time=" + lz_time + ", lz_type=" + lz_type + ", lz_remarks="
				+ lz_remarks + ", u_count=" + u_count + ", password=" + password + ", picdata=" + picdata
				+ ", deptName=" + deptName + ", jobName=" + jobName + "]";
	}
	
	
	
}
