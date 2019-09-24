package com.zcjd.app_server.service;


import com.zcjd.app_server.model.DepartmentPojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IdepartmentService {

	/**
	 * 查询所有部门的信息
	 * @return
	 * @throws Exception
	 */
	public List<DepartmentPojo> findDeptByPage(Map<String, Object> map) throws Exception;

	/**
	 * 根据id查询一条记录
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public DepartmentPojo getDeptById(String id) throws Exception;

	/**
	 * 添加部门信息
	 */
	public void saveDeptMsg(DepartmentPojo deptPojo) throws Exception;

	/**
	 * 	修改部门信息
	 */
	public void updateDeptMsg(DepartmentPojo deptPojo) throws Exception;
	
	/**
	 * 删除部门信息
	 * @param map
	 * @throws Exception
	 */
	public void deleteDeptMsg(String id) throws Exception;

	/**
	 * 查询所有的部门
	 * @return
	 * @throws Exception
	 */
	public List<DepartmentPojo> findAllDept() throws Exception ;

	/**
	 * 根据筛选条件查询所有的部门
	 * @param deptParams
	 * @return
	 */
	public List<DepartmentPojo> findDeptByMap(HashMap<String, Object> deptParams) throws Exception ;
	
}
