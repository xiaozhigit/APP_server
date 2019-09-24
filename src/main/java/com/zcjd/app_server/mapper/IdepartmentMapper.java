package com.zcjd.app_server.mapper;

import com.zcjd.app_server.model.DepartmentPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Mapper
public interface IdepartmentMapper {
	
	/**
	 * 分页查询所有部门列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<DepartmentPojo> findDeptByPage(@Param("map") Map<String, Object> map) throws Exception;
	
	/**
	 * 根据id查询一条记录
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public DepartmentPojo getDeptById(String id) throws Exception;
	
	/**
	 * 保存添加部门信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public void saveDeptMsg(DepartmentPojo deptPojo) throws Exception;
	
	/**
	 * 	修改部门信息
	 * @param deptPojo
	 * @throws Exception
	 */
	public void updateDeptMsg(DepartmentPojo deptPojo) throws Exception;
	
	/**
	 * 删除部门信息
	 * @param deptPojo
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
	public List<DepartmentPojo> findDeptByMap(@Param("map") HashMap<String, Object> deptParams) throws Exception ;
	
}
