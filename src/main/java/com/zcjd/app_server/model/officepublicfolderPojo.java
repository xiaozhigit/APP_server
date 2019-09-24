package com.zcjd.app_server.model;

import com.zcjd.annotation.GenField;

import java.io.Serializable;

//@GenTable(name = "oa_folder")
//@GenModel(packageName = "com.jida.file", modelName = "file")
public class officepublicfolderPojo implements Serializable
{
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    @GenField(labelname = "", column = "id", id = true, isnull = false)
    private Integer id;
    
    @GenField(labelname = "文件夹名", column = "name", length = 255, isnull = true)
    private String name;
    
    @GenField(labelname = "用户id", column = "userid", isnull = true)
    private String userid;
    
    @GenField(labelname = "上级ID", column = "fatherid", isnull = true)
    private Integer fatherid;
    
    private String folderpath;
    
    private String userName;// 用户名（创建者名字）
    
    private String icon; //图标
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public String getFolderpath()
    {
        return folderpath;
    }
    
    public void setFolderpath(String folderpath)
    {
        this.folderpath = folderpath;
    }
    
    public Integer getId()
    {
        return id;
    }
    
    public void setId(Integer id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public Integer getFatherid()
    {
        return fatherid;
    }
    
    public void setFatherid(Integer fatherid)
    {
        this.fatherid = fatherid;
    }
    
    @Override
    public String toString()
    {
        return "folderPojo [id=" + id + ", name=" + name + ", userid=" + userid + ", fatherid=" + fatherid + "]";
    }
    
    public String getUserid()
    {
        return userid;
    }
    
    public void setUserid(String userid)
    {
        this.userid = userid;
    }

    public String getIcon()
    {
        return icon;
    }

    public void setIcon(String icon)
    {
        this.icon = icon;
    }
    
}