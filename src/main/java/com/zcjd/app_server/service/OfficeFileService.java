package com.zcjd.app_server.service;


import com.zcjd.app_server.model.officepublicfilePojo;
import com.zcjd.app_server.model.officepublicfolderPojo;
import org.apache.ibatis.annotations.Param;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public interface OfficeFileService {
	public List<officepublicfilePojo> getfilelist(@Param("map") HashMap<String, Object> params)throws Exception;

	public List<officepublicfolderPojo> getfolderlist(HashMap<String, Object> params)throws Exception;


	public void savefile(officepublicfilePojo pojo)throws Exception;

	public void savefolder(officepublicfolderPojo pojo)throws Exception;

	public void updatefilepojo(officepublicfilePojo pojo)throws Exception;

	public void updatefolderpojo(officepublicfolderPojo pojo)throws Exception;
    public int getPublicFolderById()throws Exception;
	public void deletefile(String id)throws Exception;
	public void deletefolder(String id)throws Exception;

	public officepublicfilePojo getfileById(String id)throws Exception;

	public officepublicfolderPojo getfolderById(String id)throws Exception;

	//根据 userid 查找全部 公共文件夹 oa_office_folder
	public List<officepublicfolderPojo> getPublicFolderByAll(@Param("map") HashMap<String, Object> params)throws Exception;

	//查找全部  公共文件夹
	public List<officepublicfolderPojo> getPublicFolderAll()throws Exception;

    /***************改***************************/
    /**
     * 获取所有的文件列表
     */
    public List<officepublicfilePojo> getAllFiles()throws Exception;

    /**
     * 获取所有的文件夹列表
     * @return
     */
    public List<officepublicfolderPojo> getAllFolders()throws Exception;

    /**
     * 复制文件
     * @param pojo
     * @param dataFilePathPre
     * @throws IOException
     */
    public void insertCopyfile(officepublicfilePojo pojo, String path, String dataFilePathPre)  throws FileNotFoundException, IOException;

    /**
     * 复制文件夹
     * @param pojo
     * @param dataFilePathPre
     * @throws IOException
     */
    public void insertCopyFolder(officepublicfolderPojo pojo, String dataFilePathPre) throws IOException;

    /**
     * 删除文件
     * @param pojo
     */
    public void deletefile(officepublicfilePojo pojo, String dataFilePathPre)throws Exception;

    /**
     * 删除文件夹
     * @param pojo
     */
    public void deletefolder(officepublicfolderPojo pojo, String dataFilePathPre)throws Exception;
    /**
     * 按条件查询公共文件
     * @param params
     * @return
     * @throws Exception
     */
	public List<officepublicfilePojo> getconditionfilelist(
            @Param("map") HashMap<String, Object> params)throws Exception;
}