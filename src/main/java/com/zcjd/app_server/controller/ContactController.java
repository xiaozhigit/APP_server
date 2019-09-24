package com.zcjd.app_server.controller;

import com.zcjd.app_server.model.ChatInfo;
import com.zcjd.app_server.model.DepartmentPojo;
import com.zcjd.app_server.model.Group;
import com.zcjd.app_server.model.UserInfoPojo;
import com.zcjd.app_server.service.ContactService;
import com.zcjd.app_server.service.IdepartmentService;
import com.zcjd.app_server.vo.DeptContact;
import com.zcjd.app_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * app部门联系人控制
 * @author Administrator
 *
 */
@Controller
@RequestMapping("app_contact")
public class ContactController {

	//部门联系人service
	@Autowired
	ContactService contactService;
	//部门
	@Autowired
	IdepartmentService idepartmentService;
	//用户service
	@Autowired
	UserService UserService;
	@Value("${fileUploadPath}")
	private String uploadFilePath;
	/**
	 * 获取用户的部门联系人lo
	 */
	@ResponseBody
	@RequestMapping("loaddingDept")
	public List<DeptContact> loaddingDept(HttpServletRequest request) {
		String userId=request.getParameter("userId");
		return contactService.selectDeptContact(userId);
		//return deptContactService.selectDeptContact("12");
	}
	/**
	 * 加载联系人详细信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getUserinfo")
	public UserInfoPojo getUserinfo(HttpServletRequest rquest) {
		try {
			String userId=(String)rquest.getParameter("userId");
		return 	UserService.getUserById(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 本地保存用户聊天语音信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("saveupdate")
	public ModelMap saveupdate(ChatInfo chatInfo, HttpServletRequest request) {
		ModelMap map=new ModelMap();
		Integer value=contactService.saveCharInfo(chatInfo);
		if(value>0) {
			map.addAttribute("code",200);
			map.addAttribute("msg","消息保存成功");
		}else {
			map.addAttribute("code",405);
			map.addAttribute("msg","服务器错误");
		}
		return map;
	}

	/**
	 * 更新用户聊天消息状态
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updateMsgState")
	public ModelMap updateMsgState(HttpServletRequest request){
		ModelMap map=new ModelMap();
		String msgId=request.getParameter("msgId");
		String state= request.getParameter("state");
		Integer value=contactService.updateCharInfoState(Integer.parseInt(msgId),Integer.parseInt(state));
		if(value>0){
			map.put("code",200);
			map.put("msg","更新成功");
		}else{
			map.put("code",500);
			map.put("msg","服务器错误");
		}
	 return map;
	};
	/**
	 * 保存用户新创建的群组
	 */
	@ResponseBody
	@RequestMapping("saveGroup")
	public ModelMap saveGroup(HttpServletRequest request, HttpSession session, @RequestParam("qun_img") MultipartFile file) throws IOException {
		ModelMap modelMap=new ModelMap();
		Group  group=new Group();
		if(file!=null){
			String fileName=System.currentTimeMillis()+"_"+file.getOriginalFilename();
			File newFile=new File(uploadFilePath);
			if(!newFile.exists()){
				newFile.mkdirs();
			}
			//通过CommonsMultipartFile的方法直接写文件（注意这个时候）
			file.transferTo(new File(uploadFilePath+fileName));
			group.setGroupImg(request.getContextPath()+"/uploadImg/"+fileName);
		}else{
			group.setGroupImg("");
		}
		group.setCreateUserId(request.getParameter("qun_userid"));
		group.setGroupDesc(request.getParameter("qun_ms"));
		group.setGroupName(request.getParameter("qun_name"));
		Integer value=contactService.addGroup(group);
		if(value>0){
			modelMap.put("code",200);
			modelMap.put("msg","新增成功");
		}else{
			modelMap.put("code",500);
			modelMap.put("msg","服务器错误");
		}
		System.out.println(group.toString());
		return modelMap;
	};

	/**
	 * 用户获取创建的群信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getQunZuByUserId")
	public List<Group> getQunZuByUserId(HttpServletRequest request){
		String userId=request.getParameter("userId");
		List<Group> groups=contactService.getGroupByUserId(userId);
		return groups;
	};
	/**
	 * 获取用户所加入群的信息
	 */
	@ResponseBody
	@RequestMapping("getQunJoin")
	public List<Group> getQunJoin(HttpServletRequest request){
		String userId=request.getParameter("userId");
		List<Group> groups=contactService.getGroupJoin(userId);
		return groups;
	};

	/**
	 * 获取所有部门的简略信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getAllSimpleDept")
	public List<DepartmentPojo> getAllSimpleDept(){
		try{
			return idepartmentService.findAllDept();
		}catch(Exception e){
			return null;
		}
	}
	/**
	 * 获取所有部门下的所有用户信息
	 */
	@ResponseBody
	@RequestMapping("getDeptUser")
	public List<UserInfoPojo> getDeptUser(HttpServletRequest rquest){
		String deptId=rquest.getParameter("deptId");
		return contactService.findUsersByDeptId(deptId);
	};

	/**
	 * 用户添加联系人
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addDeptContact")
	public ModelMap addDeptContact(HttpServletRequest request){
		ModelMap modelMap=new ModelMap();
		String contactUserId=request.getParameter("userId");
		String currentUserId=request.getParameter("cuurentUserId");
			int returnValue=contactService.addDeptContact(currentUserId,contactUserId);
			if(returnValue>0){
				modelMap.put("code",200);
			}else{
				modelMap.put("code",500);
			}
		return modelMap;
	};

	/**
	 * 通过群号或者群名称查询群组
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getGroupByGroupIdOrName")
	public List<Group> getGroupByGroupIdOrName(HttpServletRequest request){
		return contactService.getGroupByGroupIdOrName(request.getParameter("keyWord"));
	};

	/**
	 * 添加群用户
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addGroupUser")
	public ModelMap addGroupUser(HttpServletRequest request){
		ModelMap modelMap=new ModelMap();
		String groupId=request.getParameter("groupId");
		String userId=request.getParameter("userId");
		Integer returnValue=contactService.addGroupUser(groupId,userId);
		if(returnValue>0){
			modelMap.put("code",200);
		}else{
			modelMap.put("code",500);
		}
		return modelMap;
	};
}
