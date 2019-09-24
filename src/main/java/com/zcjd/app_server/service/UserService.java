package com.zcjd.app_server.service;


import com.zcjd.app_server.model.UserInfoAccountPojo;
import com.zcjd.app_server.model.UserInfoPojo;
import com.zcjd.app_server.model.UserTreePojo;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface UserService {

	/** 添加用户信息 
	 * @return */

	public List<UserInfoPojo> findUserByPage(HashMap<String, Object> params) throws Exception;
	/**
	 * 更新User
	 * @param pojo
	 */

	public void updateUser(UserInfoPojo pojo)throws Exception;	
	/**
	 * 根据id查询User
	 * @param id
	 * @return
	 */

	public UserInfoPojo getUserById(String id)throws Exception;	
	/**
	 * 删除User
	 * @param id
	 */
	public void deleteUser(String id)throws Exception;
	
	/**
	 * 添加
	 * @param pojo
	 * @throws Exception
	 */
	public void saveUser(UserInfoPojo pojo) throws Exception;

	
	/**
	 * 模糊查询
	 * @param deptId
	 * @return
	 */
	public List<UserInfoPojo> selectUserLike(@Param("map") HashMap<String, Object> params);
	
	/**
	 * 查询所有user并封装成UserTreePojo
	 * @return
	 * @throws Exception
	 */
	public List<UserTreePojo> findAllUser() throws Exception;
	
	/**
	 * 员工离职
	 */
	public void updateResigningUser(UserInfoPojo user) throws Exception;

	/**
	 * {账号管理}-分页查询 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<UserInfoAccountPojo> findUserInfoAccountByPage(HashMap<String, Object> params) throws Exception;
	
	
	/**
	 * 	获取编号
	 * @param coderuleId
	 * @return
	 */
	public String getContractNumberList(String codeId) throws Exception;
	
	/**
	 * 账号启用/停用
	 * @param userInfoId
	 * @throws Exception
	 */
	public void updateUserInfoAccountState(HashMap<String, Object> params) throws Exception ;

}
	
