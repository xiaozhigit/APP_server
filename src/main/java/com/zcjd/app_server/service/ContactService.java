package com.zcjd.app_server.service;

import com.zcjd.app_server.model.ChatInfo;
import com.zcjd.app_server.model.Group;
import com.zcjd.app_server.model.UserInfoPojo;
import com.zcjd.app_server.vo.DeptContact;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface ContactService {
	/**
	 * 通过用户id查询联系人
	 * @param id
	 * @return
	 */
	public List<DeptContact> selectDeptContact(String id) ;
	/**
	 * 保存用户与联系人的聊天信息
	 * @param chatInfo
	 * @return
	 */
	public Integer saveCharInfo(ChatInfo chatInfo);

	/**
	 * 更新聊天消息状态
	 * @param msgId
	 * @param state
	 * @return
	 */
    Integer updateCharInfoState(int msgId, int state);

	/**
	 * 添加群组
	 * @param group
	 * @return
	 */
    Integer addGroup(Group group);

	/**
	 * 通过用户id获取其创建的所有群组
	 * @param userId
	 * @return
	 */
	List<Group> getGroupByUserId(String userId);

	/**
	 * 通过用户id获取其加入的群的信息
	 * @param userId
	 * @return
	 */
	List<Group> getGroupJoin(String userId);

	/**
	 * 通过部门id查询部门下的用户
	 * @param deptId
	 * @return
	 */
    List<UserInfoPojo> findUsersByDeptId(String deptId);

	/**
	 * 用户添加部门联系人
	 * @param id
	 * @param contactUserId
	 * @return
	 */
	Integer addDeptContact(String id, String contactUserId);
	/**
	 * 通过群号或者群名称查询群组
	 * @return
	 */
	List<Group> getGroupByGroupIdOrName(String keyWord);

	/**
	 * 添加群用户
	 * @param groupId
	 * @param userId
	 * @return
	 */
	Integer addGroupUser(String groupId, String userId);
}
