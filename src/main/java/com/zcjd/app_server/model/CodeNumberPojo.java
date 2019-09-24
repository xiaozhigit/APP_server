package com.zcjd.app_server.model;

import java.io.Serializable;

/**
 * 编号表
 * 所有生成的编号都在这张表，根据类型区分
 * @author Administrator
 *
 */
public class CodeNumberPojo implements Serializable {

	private String id;
	private String type;//编码所属类型
	private String codeId;//编码规则ＩＤ
	private String number;//生成后的编码
	private int first_number;//流水号
	private int c_count;//流水号个数
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCodeId() {
		return codeId;
	}
	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getFirst_number() {
		return first_number;
	}
	public void setFirst_number(int first_number) {
		this.first_number = first_number;
	}
	public int getC_count() {
		return c_count;
	}
	public void setC_count(int c_count) {
		this.c_count = c_count;
	}
	
	
}
