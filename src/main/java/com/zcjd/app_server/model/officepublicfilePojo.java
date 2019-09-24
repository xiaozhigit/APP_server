package com.zcjd.app_server.model;

import com.zcjd.annotation.GenField;
import com.zcjd.annotation.GenModel;
import com.zcjd.annotation.GenTable;

import java.io.Serializable;

@GenTable(name = "sys_public_files")
@GenModel(packageName = "com.zcjd.officepublicfile", modelName = "officepublicfilePojo")
public class officepublicfilePojo implements Serializable
{	
	@GenField(labelname = "数据库标识，主键", column = "id")
	private Integer id;	
	@GenField(labelname = "文件/文件夹名称", column = "file_name")
	private String file_name;	
	@GenField(labelname = "上级文件夹ＩＤ", column = "father_id")
	private Integer father_id;	
	@GenField(labelname = "类型:附件类型：0=文件夹　1=文件", column = "file_type")	
	private Integer  file_type;	
	@GenField(labelname = "附件路径", column = "file_path")
	private String file_path;	
	@GenField(labelname = "文件大小", column = "file_size")
	private String file_size;	
	@GenField(labelname = "下载次数", column = "file_count")
	private Integer file_count;	
	@GenField(labelname = "开始时间", column = "start_time")
	private String start_time;
	@GenField(labelname = "结束时间", column = "end_time")
	private String end_time;
		
	@GenField(labelname = "登记人", column = "create_id")
	private String create_id;
		
	@GenField(labelname = "登记时间", column = "create_time")
	private String create_time;

	@GenField(labelname = "删除状态（0=未删除，1=已删除;默认值为0）", column = "del_state")
	private Integer del_state;
	
	private String file_suffix;//文件后缀
	
	private Integer allowdownload;// 是否允许下载 1 是 0 否
    
    private String userName;// 用户名（上传者名字）
    
    private String  icon;
    private String  realname;
    
	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public Integer getFather_id() {
		return father_id;
	}

	public void setFather_id(Integer father_id) {
		this.father_id = father_id;
	}

	public Integer getFile_type() {
		return file_type;
	}

	public void setFile_type(Integer file_type) {
		this.file_type = file_type;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public String getFile_size() {
		return file_size;
	}

	public void setFile_size(String file_size) {
		this.file_size = file_size;
	}

	public Integer getFile_count() {
		return file_count;
	}

	public void setFile_count(Integer file_count) {
		this.file_count = file_count;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
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

	public Integer getAllowdownload() {
		return allowdownload;
	}

	public void setAllowdownload(Integer allowdownload) {
		this.allowdownload = allowdownload;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFile_suffix() {
		return file_suffix;
	}

	public void setFile_suffix(String file_suffix) {
		this.file_suffix = file_suffix;
	}
    
   
    
}