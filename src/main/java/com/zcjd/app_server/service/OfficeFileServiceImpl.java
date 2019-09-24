package com.zcjd.app_server.service;


import com.zcjd.app_server.mapper.IOfficeFileMapper;
import com.zcjd.app_server.model.officepublicfilePojo;
import com.zcjd.app_server.model.officepublicfolderPojo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class OfficeFileServiceImpl implements OfficeFileService
{
    @Autowired
    private IOfficeFileMapper mapper;
    
    public List<officepublicfilePojo> getfilelist(@Param("map")HashMap<String, Object> params)
    {
        return this.mapper.getfilelist(params);
    }
    
    public void savefile(officepublicfilePojo pojo)
    {
        this.mapper.savefile(pojo);
    }
    
    public List<officepublicfolderPojo> getfolderlist(HashMap<String, Object> params)
    {
        return this.mapper.getfolderlist(params);
    }
    
    public void savefolder(officepublicfolderPojo pojo)
    {
        this.mapper.savefolder(pojo);
    }
    
    public void updatefilepojo(officepublicfilePojo pojo)
    {
        this.mapper.updatefilepojo(pojo);
    }
    
    public void deletefile(String id)
    {
        this.mapper.deletefile(id);
    }
    
    public officepublicfilePojo getfileById(String id)
    {
        return this.mapper.getfileById(id);
    }
    
    public officepublicfolderPojo getfolderById(String id)
    {
        
        return this.mapper.getfolderById(id);
    }
    
    public void deletefolder(String id)
    {
        this.mapper.deletefolder(id);
        
    }
    
    public void updatefolderpojo(officepublicfolderPojo pojo)
    {
        this.mapper.updatefolderpojo(pojo);
        
    }
    
    public List<officepublicfilePojo> getsharefilelist(Integer state)
    {
        
        return this.mapper.getsharefilelist(state);
    }
    
    // 根据 userid 查找全部 公共文件夹 oa_office_folder
    public List<officepublicfolderPojo> getPublicFolderByAll(@Param("map") HashMap<String, Object> params)
    {
        return this.mapper.getPublicFolderByAll(params);
    }
    
    // 查找全部 公共文件夹
    public List<officepublicfolderPojo> getPublicFolderAll()
    {
        return this.mapper.getPublicFolderAll();
    }
    
    public int getPublicFolderById()
    {
        return this.mapper.getPublicFolderById();
    }
    
    /*************** 改 ***************************/
    /**
     * 获取所有的文件列表
     */
    public List<officepublicfilePojo> getAllFiles()
    {
        return this.mapper.getAllFiles();
    }
    
    /**
     * 获取所有的文件夹列表
     * 
     * @return
     */
    public List<officepublicfolderPojo> getAllFolders()
    {
        return this.mapper.getAllFolders();
    }

    public void insertCopyfile(officepublicfilePojo pojo, String filePath, String pre) throws IOException
    {
        
        File org = new File(pre+filePath);
        
        File target = new File(pre+pojo.getFile_path());

        if(org.canRead())
        {
            FileInputStream in = new FileInputStream(org);
            FileOutputStream out = new FileOutputStream(target);
            byte[] bufferd = new byte[102400];
            
            while(in.read(bufferd)!=-1)
            {
                out.write(bufferd, 0, bufferd.length);
            }
            
            out.flush();
            
            in.close();
            out.close();
        }
        this.mapper.savefile(pojo);
        
    }

    public void insertCopyFolder(officepublicfolderPojo pojo, String dataFilePathPre) throws IOException
    {
        //记录要复制文件夹的id
        int folderId = pojo.getId();
        
        pojo.setId(null);
        
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("fatherid", pojo.getFatherid());
        List<officepublicfolderPojo> brothers = this.mapper.getfolderlist(param);
        
        int count = 0;
        String tempName = new String(pojo.getName());
        for (int i=0; i<brothers.size(); i++)
        {
        	officepublicfolderPojo pj = brothers.get(i);
            
            if (pj.getName().equals(tempName) && !pj.getId().equals(pojo.getId()))
            {
                count++;
                tempName = pojo.getName()+"("+count+")";
                i = -1;
            }
        }
        
        pojo.setName(tempName);
        
        this.mapper.savefolder(pojo);
        
        HashMap<String,Object> params = new HashMap<String, Object>();
        params.put("fatherid", folderId);
        //复制起下面的文件夹和文件
        List<officepublicfolderPojo> folders = this.mapper.getfolderlist(params);
        List<officepublicfilePojo> files = this.mapper.getfilelist(params);
        
        for(int i=0; folders!=null && i<folders.size(); i++)
        {
            officepublicfolderPojo folder =  folders.get(i);
            
            folder.setFatherid(pojo.getId());
            
            this.insertCopyFolder(folder, dataFilePathPre);
        }
        for(int i=0; files!=null && i<files.size(); i++)
        {
            officepublicfilePojo file =  files.get(i);

            file.setId(null);
            file.setFather_id(pojo.getId());
            String filepath1 =file.getFile_path();
           
         // 计算文件类型
			String sufffile = file.getFile_path().substring(file.getFile_path().lastIndexOf('.') + 1);
			String realFileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + (sufffile.equals("") ? "" : ("." + sufffile));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String sonPath = sdf.format(new Date());
			String Filepath = "/officefile/" + sonPath;// 
			String filepath = Filepath  +"/"+ realFileName;
			file.setFile_path(filepath);
            file.setFile_count(0);
            this.insertCopyfile(file, filepath1, dataFilePathPre);
        }
    }

    public void deletefile(officepublicfilePojo pojo, String dataFilePathPre)
    {
        File target = new File(dataFilePathPre+pojo.getFile_path());
     
        
        if(target.canExecute()) target.delete();
    
        
        this.mapper.deletefile(pojo.getId().toString());
    }

    public void deletefolder(officepublicfolderPojo pojo, String dataFilePathPre)
    {
        this.mapper.deletefolder(pojo.getId().toString());
        
        HashMap<String,Object> params = new HashMap<String, Object>();
        params.put("fatherid", pojo.getId());
        //复制起下面的文件夹和文件
        List<officepublicfolderPojo> folders = this.mapper.getfolderlist(params);
        List<officepublicfilePojo> files = this.mapper.getfilelist(params);
        
        for(int i=0; folders!=null && i<folders.size(); i++)
        {
            officepublicfolderPojo folder =  folders.get(i);
            
            this.deletefolder(folder, dataFilePathPre);
        }
        
        for(int i=0; files!=null && i<files.size(); i++)
        {
            officepublicfilePojo file =  files.get(i);

            this.deletefile(file, dataFilePathPre);
        }
    }

	public List<officepublicfilePojo> getconditionfilelist(
			HashMap<String, Object> params) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getconditionfilelist(params);
	}
}