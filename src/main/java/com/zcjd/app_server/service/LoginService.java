package com.zcjd.app_server.service;



import com.zcjd.app_server.model.UserInfoPojo;

import java.util.List;
import java.util.Map;

public interface LoginService {

	/**
	 * 根据工号查询　（登陆）
	 * @param 
	 * @return
	 * @throws Exception
	 */
	public List<UserInfoPojo> getUserInfoByNumber(Map<String, Object> map) throws Exception;
	/**
	 * 根据工号查询　（姓名）
	 * @param 
	 * @return
	 * @throws Exception
	 */
	public List<UserInfoPojo> getUserInfoByName(Map<String, Object> map) throws Exception;
}
