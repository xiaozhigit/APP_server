package com.zcjd.app_server.mapper;

import com.zcjd.app_server.model.UserInfoPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
@Mapper
public interface ILoginMapper {

	
	
	/**
	 * 根据工号查询　（登陆）
	 * @param 
	 * @return
	 * @throws Exception
	 */
	public List<UserInfoPojo> getUserInfoByNumber(@Param("map") Map<String, Object> map) throws Exception;
	/**
	 * 根据工号查询　（姓名）
	 * @param 
	 * @return
	 * @throws Exception
	 */
	public List<UserInfoPojo> getUserInfoByName(@Param("map") Map<String, Object> map) throws Exception;
	
}
