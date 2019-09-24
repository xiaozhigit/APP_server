package com.zcjd.app_server.mapper;

import com.zcjd.app_server.model.officepublicfilePojo;
import com.zcjd.app_server.model.officepublicfolderPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface IOfficeFileMapper
{
    public List<officepublicfilePojo> getfilelist(@Param("map") HashMap<String, Object> params);
    
    public List<officepublicfolderPojo> getfolderlist(@Param("map") HashMap<String, Object> params);
    
    public List<officepublicfilePojo> getsharefilelist(Integer state);
    
    public void savefile(officepublicfilePojo pojo);
    
    public void savefolder(officepublicfolderPojo pojo);
    
    public void updatefilepojo(officepublicfilePojo pojo);
    
    public void updatefolderpojo(officepublicfolderPojo pojo);
    
    public void deletefile(String id);
    
    public void deletefolder(String id);
    
    public int getPublicFolderById();
    
    public officepublicfilePojo getfileById(String id);
    
    public officepublicfolderPojo getfolderById(String id);
    
    // 根据 userid 查找全部 公共文件夹 oa_office_folder
    public List<officepublicfolderPojo> getPublicFolderByAll(@Param("map") HashMap<String, Object> params);
    
    // 查找全部 公共文件夹
    public List<officepublicfolderPojo> getPublicFolderAll();
    
    /***************改***************************/
    /**
     * 获取所有的文件列表
     */
    public List<officepublicfilePojo> getAllFiles();
    
    /**
     * 获取所有的文件夹列表
     * @return
     */
    public List<officepublicfolderPojo> getAllFolders();
    /**
     * 按条件查询公共文件
     * @param params
     * @return
     * @throws Exception
     */
	public List<officepublicfilePojo> getconditionfilelist(
            @Param("map") HashMap<String, Object> params)throws Exception;
    
}