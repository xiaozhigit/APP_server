package com.zcjd.app_server.model;

import java.io.Serializable;

public class CoderulePojo implements Serializable {
	private String id;
	private String name;
	private String prefixValue;//前缀值
	private String prefixSeparatorDate;//前缀与日期间隔符
	private String dateStyle;//日期格式
	private String dateSeparatorNumber;//日期与流水号间隔符
	private Integer numberLength;//流水号长度
	private Integer firstNumber;//流水号起始值
	private String numberSeparatorSuffix;//流水号与后缀间隔符
	private String suffixValue;//后缀值
	private Integer status;//启用状态（0 停用，1 启用）
	private String codeunique;//唯一标识
	/**
	 * <option value="u_number">人员工号</option>
		<option value="c_number">合同编号</option>
		<option value="p_number">项目编号</option>
		目前只用到这三个所以在界面上写死的
	 */
	private String codeId;//编码类型ID
	
	private Integer delete_state;
	
	private String codeName;//编码类型名称
	

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public Integer getDelete_state() {
		return delete_state;
	}

	public void setDelete_state(Integer delete_state) {
		this.delete_state = delete_state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrefixValue() {
		return prefixValue;
	}

	public void setPrefixValue(String prefixValue) {
		this.prefixValue = prefixValue;
	}

	public String getPrefixSeparatorDate() {
		return prefixSeparatorDate;
	}

	public void setPrefixSeparatorDate(String prefixSeparatorDate) {
		this.prefixSeparatorDate = prefixSeparatorDate;
	}

	public String getDateStyle() {
		return dateStyle;
	}

	public void setDateStyle(String dateStyle) {
		this.dateStyle = dateStyle;
	}

	public String getDateSeparatorNumber() {
		return dateSeparatorNumber;
	}

	public void setDateSeparatorNumber(String dateSeparatorNumber) {
		this.dateSeparatorNumber = dateSeparatorNumber;
	}

	public Integer getNumberLength() {
		return numberLength;
	}

	public void setNumberLength(Integer numberLength) {
		this.numberLength = numberLength;
	}

	public Integer getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(Integer firstNumber) {
		this.firstNumber = firstNumber;
	}

	public String getNumberSeparatorSuffix() {
		return numberSeparatorSuffix;
	}

	public void setNumberSeparatorSuffix(String numberSeparatorSuffix) {
		this.numberSeparatorSuffix = numberSeparatorSuffix;
	}

	public String getSuffixValue() {
		return suffixValue;
	}

	public void setSuffixValue(String suffixValue) {
		this.suffixValue = suffixValue;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCodeunique() {
		return codeunique;
	}

	public void setCodeunique(String codeunique) {
		this.codeunique = codeunique;
	}

	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}
}