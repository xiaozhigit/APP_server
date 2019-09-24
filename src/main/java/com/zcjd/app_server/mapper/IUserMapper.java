package com.zcjd.app_server.mapper;


import com.zcjd.app_server.model.UserInfoAccountPojo;
import com.zcjd.app_server.model.UserInfoPojo;
import com.zcjd.app_server.model.UserTreePojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Mapper
public interface IUserMapper {
	
	/**
	 * 用户登陆
	 * 
	 * @param map
	 * @return
	 */

	public UserInfoPojo getUserByLogin(@Param("map") Map<String, Object> map);
	/**
	 * 分页查询User 
	 * @param params
	 * @return
	 */

	public List<UserInfoPojo> findUserByPage(@Param("map") HashMap<String, Object> params);
	/**
	 * 添加User
	 * @param pojo
	 */

	public void saveUser(UserInfoPojo pojo) throws Exception;
	/**
	 * 更新User
	 * @param pojo
	 */

	public void updateUser(UserInfoPojo pojo)throws Exception;
	/**
	 * 删除User
	 * @param id
	 */
	public void deleteUser(String id)throws Exception;

	/**
	 * 根据id查询User
	 * @param id
	 * @return
	 */

	public UserInfoPojo getUserById(String id)throws Exception;	
	/**
	 * 查询所有工号(账号)
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<String> getNumberList(String coderuleId) throws Exception;

	/**
	 *
	 * 根据账号的密码找用户
	 * @param id
	 * @param account
	 * @return
	 */
	public int getExistUserByAccountAndId(String id, String account);

	/**
	 * 选择人员使用查询所有未删除用户
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<UserInfoPojo> getUsersListAll() throws Exception;


	/**
	 * 根据账号查询user
	 * @param account
	 * @return
	 * @throws Exception
	 */

	public UserInfoPojo getUserByAccount(String account) throws Exception;	
	/**
	 * 修改密码
	 * @param u
	 * @throws Exception
	 */

	public void updatePassword(UserInfoPojo u)throws Exception;
	/**
	 * 根据deptId查询相关人员
	 * @param deptId
	 * @return
	 */

	public List<UserInfoPojo> getUserByDeptId(String deptId);
	
	/**
	 * 模糊查询
	 * @param deptId
	 * @return
	 */
	public List<UserInfoPojo> selectUserLike(@Param("map") HashMap<String, Object> params);
	
	/**
	 * 查询所有user并封装成UserTreePojo
	 * @return
	 * @see com.zcjd.userinfo.pojo.UserTreePojo
	 * @throws Exception
	 */
	public List<UserTreePojo> findAllUser() throws Exception;
	
	
	/**
	 * 员工离职
	 */
	public void resigningUser(UserInfoPojo user) throws Exception;
	
	/**
	 * {账号管理}-分页查询 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<UserInfoAccountPojo> findUserInfoAccountByPage(@Param("map") HashMap<String, Object> params) throws Exception;
	
	
	
	/**
	 * 	获取编号
	 * @return
	 * @throws Exception
	 */
	public List<String> getUserNumberList() throws Exception;
	
	/**
	 * 账号启用/停用
	 * @param userInfoId
	 * @throws Exception
	 */
	public void updateUserInfoAccountState(@Param("map") HashMap<String, Object> params) throws Exception;
	/**
	 * 通过部门id查询部门下员工信息
	 * @param params
	 * @return
	 */

	public List<UserInfoPojo> findUserByDeptId(String deptId);

}