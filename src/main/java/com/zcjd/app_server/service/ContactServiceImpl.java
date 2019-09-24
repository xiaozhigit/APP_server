package com.zcjd.app_server.service;

import com.zcjd.app_server.mapper.ContactMapper;
import com.zcjd.app_server.mapper.IUserMapper;
import com.zcjd.app_server.model.ChatInfo;
import com.zcjd.app_server.model.DepartmentPojo;
import com.zcjd.app_server.model.Group;
import com.zcjd.app_server.model.UserInfoPojo;
import com.zcjd.app_server.vo.DeptContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 部门联系人服务类
 * 
 * @author Administrator
 *
 */
@Service
public class ContactServiceImpl implements ContactService {
	//部门联系人mapper
	@Autowired
	ContactMapper contactMapper;
	//用户mapper
	@Autowired
	IUserMapper iUserMapper;
	@Override
	public List<DeptContact> selectDeptContact(String id) {
		//当前用户所有联系人信息
		List<UserInfoPojo> contactInfos = contactMapper.selectContactsInfoById(id);
		//所有部门信息
		List<DepartmentPojo> departmentPojos = contactMapper.selectAllDepartment();
		
		Map<DepartmentPojo, List<UserInfoPojo>> deptIdMap = new HashMap<DepartmentPojo, List<UserInfoPojo>>();
		//遍历部门
		for (DepartmentPojo departmentPojo : departmentPojos) {
			//将当前部门id作为key存入map中
			deptIdMap.put(departmentPojo, new ArrayList<UserInfoPojo>());
			//遍历用户
			for (UserInfoPojo userInfoPojo : contactInfos) {
				//若该用户为当前部门下的人则将该用户信息存入部门id为可以的联系人集合中
				if (departmentPojo.getId().equals(userInfoPojo.getDeptId())) {
					deptIdMap.get(departmentPojo).add(userInfoPojo);
				}
			}
		}
		//将map中数据封装到DeptContact集合中
		List<DeptContact> deptContacts=new ArrayList<DeptContact>();
		
		for (DepartmentPojo departmentPojo : deptIdMap.keySet()) {
			//剔出无联系人的部门
			if(deptIdMap.get(departmentPojo).size()>0) {
				DeptContact deptContact=new DeptContact();
				deptContact.setId(departmentPojo.getId());
				deptContact.setD_name(departmentPojo.getD_name());
				deptContact.setDel_state(departmentPojo.getDel_state());
				deptContact.setRemarks(departmentPojo.getRemarks());
				deptContact.setSort(departmentPojo.getSort());
				deptContact.setTel(departmentPojo.getTel());
				deptContact.setPid(departmentPojo.getPid());
				deptContact.setUserId(departmentPojo.getUserId());
				deptContact.setUserName(departmentPojo.getUserName());
				deptContact.setUserInfos(deptIdMap.get(departmentPojo));
				deptContacts.add(deptContact);
			}
		}
		
		return deptContacts;
	}

	@Override
	public Integer saveCharInfo(ChatInfo chatInfo) {
		return contactMapper.saveChatInfo(chatInfo);
	}

	@Override
	public Integer updateCharInfoState(int msgId, int state) {
		return contactMapper.updateCharInfoState(msgId,state);
	}

	@Override
	public Integer addGroup(Group group) {
		return contactMapper.addGroup(group);
	}

	@Override
	public List<Group> getGroupByUserId(String userId) {
		return contactMapper.getGroupByUserId(userId);
	}

	@Override
	public List<Group> getGroupJoin(String userId) {
		return contactMapper.getGroupJoin(userId);
	}

	@Override
	public List<UserInfoPojo> findUsersByDeptId(String deptId) {
		return iUserMapper.findUserByDeptId(deptId);
	}

	@Override
	public Integer addDeptContact(String currentUserId, String contactUserId) {
		return contactMapper.addDeptContact(currentUserId,contactUserId);
	}

	@Override
	public List<Group> getGroupByGroupIdOrName(String keyWord) {
		return contactMapper.getGroupByGroupIdOrName(keyWord);
	}

	@Override
	public Integer addGroupUser(String groupId, String userId) {
		return contactMapper.addGroupUser(groupId,userId);
	}

}
