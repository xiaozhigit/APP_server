package com.zcjd.app_server.mapper;

import com.zcjd.app_server.model.CodeNumberPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface ICoderuleMapper {
	
	/** 分页查询Coderule */
	public List<com.zcjd.app_server.model.CoderulePojo> getCoderuleByPage(
            @Param("map") HashMap<String, Object> params)throws Exception;

	/** 添加Coderule */
	public void saveCoderule(com.zcjd.app_server.model.CoderulePojo pojo)throws Exception;

	/** 更新Coderule */
	public void updateCoderule(com.zcjd.app_server.model.CoderulePojo pojo)throws Exception;

	/** 删除Coderule */
	public void deleteCoderule(String id)throws Exception;

	/** 根据id查询Coderule */
	public com.zcjd.app_server.model.CoderulePojo getCoderuleById(String id)throws Exception;

	/**
	 * 通过唯一标识codeunique="合同编码"查询合同的类型
	 * @param codeunique
	 * @return
	 */
	public List<com.zcjd.app_server.model.CoderulePojo> getAllContractTypeByCodeunique(String codeunique)throws Exception;

	/***
	 * 根据编码类型查询
	 * @param type_name
	 * @return
	 */
	public List<com.zcjd.app_server.model.CoderulePojo> getCodeRuleByTypeName(String codeId)throws Exception;

	/**码表维护相关*/

	/** 添加码表 */
	public void saveCoderuleNumber(CodeNumberPojo pojo)throws Exception;

	/** 更新码表 */
	public void updateCoderuleNumber(CodeNumberPojo pojo)throws Exception;

	/** 删除码表 */
	public void deleteCoderuleNumber(String id)throws Exception;
	/***
	 * 根据编码类型查询所有已生成的编码
	 * @param type_name
	 * @return
	 */
	public List<CodeNumberPojo> getCodeRuleByTypeNumber(String type)throws Exception;

	/**
	 * 根据规则ＩＤ查询流水号最大值
	 * @param codeId
	 * @return
	 * @throws Exception
	 */
	public CodeNumberPojo getCodeNumberMax(@Param("codeId") String codeId, @Param("count") Integer count)throws Exception;
}