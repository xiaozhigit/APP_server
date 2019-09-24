package com.zcjd.app_server.controller;

import com.zcjd.app_server.base.page.PageInfo;
import com.zcjd.app_server.model.AttendanceSetPojo;
import com.zcjd.app_server.model.OfficepublicFilesTreeVo;
import com.zcjd.app_server.model.officepublicfilePojo;
import com.zcjd.app_server.model.officepublicfolderPojo;
import com.zcjd.app_server.service.OfficeFileService;
import com.zcjd.app_server.service.PersionService;
import net.sf.json.JSONArray;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 个人中心控制类
 */
@Controller
@RequestMapping("app_persion")
public class PersionController {
    private final static Log logger = LogFactory.getLog(PersionController.class);
    @Resource
    private OfficeFileService service;
    @Autowired
    private PersionService persionService;
    /**
     * 获取要显示的文件和文件夹列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("loadOfficesGrid")
    public void loadOfficesGrid(int page, int rows, HttpServletRequest request, HttpServletResponse response) throws Exception {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPage(page-1);
        pageInfo.setShowCount(rows);
        // 参数：要显示子集的目录id(第一级的“0”)
        String pid = request.getParameter("folderId");
        String fileName = request.getParameter("file_name");// 文件名称
        List<OfficepublicFilesTreeVo> listVo = new ArrayList<OfficepublicFilesTreeVo>();
        Integer grandpaid = 0;
        // 获取文件夹列表
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("page", pageInfo);
        if (pid == null || pid.equals("")) {
            pid = "0";
        }
        params.put("fatherid", pid);

        // 文件名称
        if (fileName != null && !"".equals(fileName)) {
            params.put("fileName", fileName);
            request.setAttribute("fileName", fileName);
        }

        String userName = request.getParameter("userName");
        params.put("userName", userName);
        // 按条件查询文件 ，不分文件夹阶级
        if (fileName != null && !"".equals(fileName) || userName != null && !"".equals(userName)) {
            List<officepublicfilePojo> file_list = this.service.getconditionfilelist(params);

            for (officepublicfilePojo pojo : file_list) {
                OfficepublicFilesTreeVo vo = new OfficepublicFilesTreeVo();
                vo.setId(pojo.getId());
                vo.setName(pojo.getFile_name());
                vo.setPath(pojo.getFile_path());
                vo.setFatherid(pojo.getFather_id());
                vo.setFolder(false);
                //vo.setIcon(icon);
                vo.setUserid(pojo.getCreate_id());
                vo.setUserName(pojo.getUserName());
                vo.setNumber(pojo.getFile_count());
                vo.setAllowdownload(pojo.getAllowdownload());
                vo.setSize(pojo.getFile_size());
                //	vo.setRealname(pojo.getRealname());
                listVo.add(vo);
            }
            request.setAttribute("file_list", file_list);
        } else {
            // 按文件夹阶级查询
            List<officepublicfolderPojo> folder_list = this.service.getfolderlist(params);
            officepublicfolderPojo p = this.service.getfolderById(pid);
            grandpaid = p == null ? 0 : p.getFatherid();

            // 获取上传者或创建者的名字
            for (officepublicfolderPojo pojo : folder_list) {
                OfficepublicFilesTreeVo vo = new OfficepublicFilesTreeVo();
                vo.setId(pojo.getId());
                vo.setName(pojo.getName());
                vo.setPath(pojo.getFolderpath());
                vo.setFatherid(pojo.getFatherid());
                vo.setFolder(true);
                vo.setUserid(pojo.getUserid());
                vo.setUserName(pojo.getUserName());
                listVo.add(vo);
            }
            // 获取文件列表
            List<officepublicfilePojo> file_list = this.service.getfilelist(params);
            for (officepublicfilePojo pojo : file_list) {
                OfficepublicFilesTreeVo vo = new OfficepublicFilesTreeVo();
                vo.setId(pojo.getId());
                vo.setName(pojo.getFile_name());
                vo.setPath(pojo.getFile_path());
                vo.setFatherid(pojo.getFather_id());
                vo.setFolder(false);
                //vo.setIcon(icon);
                vo.setUserid(pojo.getCreate_id());
                vo.setUserName(pojo.getUserName());
                vo.setNumber(pojo.getFile_count());
                vo.setAllowdownload(pojo.getAllowdownload());
                vo.setSize(pojo.getFile_size());
                vo.setFile_suffix(pojo.getFile_suffix());
                listVo.add(vo);
            }
            // request.setAttribute("file_list", file_list);
            // request.setAttribute("folder_list", folder_list);
            request.setAttribute("grandpaid", grandpaid);// 父id的父id用于返回上一级用
            request.setAttribute("fatherid", pid);// 父id用于新建文件夹用
        }

        // request.setAttribute("showPath", p==null?"":p.getFolderpath() + p.getName() + File.separator);
        // 获取sub按钮
        String navId = request.getParameter("navId");// 资源ＩＤ
        request.setAttribute("navId", navId);
        String json = JSONArray.fromObject(listVo).toString();
        String rtn = "{\"total\":"+pageInfo.getTotalResult()+",\"rows\":" + json + ",\"grandpaid\":" + pid + "}";

        // 转码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.getWriter().println(rtn);
    }

    /**
     * 获取打卡地点的经纬度
     * @return
     */
    @ResponseBody
    @RequestMapping("getCheckInAddre")
    public ModelMap getCheckInAddre(){
        ModelMap map=new ModelMap();
        List<AttendanceSetPojo> attendanceSetPojos=persionService.getCheckInAddre();
        if(!attendanceSetPojos.isEmpty()){
            map.put("code",200);
            map.put("addreList",attendanceSetPojos);
        }else{
            map.put("code",500);
            map.put("msg","获取数据错误");
        }
      return map;
    };

    /**
     * app提交打卡数据
     * @return
     */
    @ResponseBody
    @RequestMapping("putCheckInData")
    public ModelMap putCheckInData(HttpServletRequest request){
        ModelMap map=new ModelMap();
        String userId=request.getParameter("userId");
        String lon=request.getParameter("lon");
        String lat=request.getParameter("lat");
        String address=request.getParameter("address");
        logger.debug("userId="+userId+",lon="+lon+",lat="+lat+"address="+address);
       Integer res=persionService.putCheckInData(userId,lon,lat,address);
       if(res>0){
           map.put("code",200);
       }else {
           map.put("code",500);
           map.put("msg","服务器错误");
       }
        return map;
    };
}
