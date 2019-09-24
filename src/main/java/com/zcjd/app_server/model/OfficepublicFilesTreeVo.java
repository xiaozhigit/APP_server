package com.zcjd.app_server.model;

public class OfficepublicFilesTreeVo {
	
	private Integer id;
	private String name;//名称
	private String icon;//类型图标
	private boolean isFolder = false;//是否文件夹
    private String userid;//上传者/创建者
    private Integer fatherid;//上级ID
    private String path;//文件路径
    private Integer state;//是否允许下载 0 是 1 否
    private String file_suffix;//文件后缀
    private String size;//文件大小
    private Integer number;//下载次数
    
    private Integer allowdownload;// 是否允许下载 1 是 0 否
    
   
    
    private String userName;// 用户名（创建者名字）
    
	public String getFile_suffix() {
		return file_suffix;
	}

	public void setFile_suffix(String file_suffix) {
		this.file_suffix = file_suffix;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public boolean isFolder() {
		return isFolder;
	}

	public void setFolder(boolean isFolder) {
		this.isFolder = isFolder;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Integer getFatherid() {
		return fatherid;
	}

	public void setFatherid(Integer fatherid) {
		this.fatherid = fatherid;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
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

	
	
	

}
