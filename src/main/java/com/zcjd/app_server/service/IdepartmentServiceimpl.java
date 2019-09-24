package com.zcjd.app_server.service;


import com.zcjd.app_server.mapper.IdepartmentMapper;
import com.zcjd.app_server.model.DepartmentPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IdepartmentServiceimpl implements IdepartmentService{
	
	@Autowired
	IdepartmentMapper idepartmentMapper;
	
	/**
	 * 查询所有部门的信息
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<DepartmentPojo> findDeptByPage(Map<String,Object> map) throws Exception {
		return idepartmentMapper.findDeptByPage(map);
	}
	
	
	/**
	 * 保存部门信息
	 */
	@Override
	public void saveDeptMsg(DepartmentPojo deptPojo) throws Exception {
		idepartmentMapper.saveDeptMsg(deptPojo);
	}

	/**
	 * 修改部门信息
	 */
	@Override
	public void updateDeptMsg(DepartmentPojo deptPojo) throws Exception {
		idepartmentMapper.updateDeptMsg(deptPojo);
	}

	
	/**
	 * 删除部门信息
	 */
	@Override
	public void deleteDeptMsg(String id) throws Exception {
		//先看一下此目录下有没有子目录，所以此id实际上是pid,然后递归删除
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("pid", id);
		List<DepartmentPojo> deptlist = idepartmentMapper.findDeptByPage(map);
		if(deptlist.size()>0) {
			for(DepartmentPojo pojo : deptlist) {
				deleteDeptMsg(pojo.getId());
			}
		}
		idepartmentMapper.deleteDeptMsg(id);
	}
	
	public DepartmentPojo getDeptById(String id) throws Exception {
		return this.idepartmentMapper.getDeptById(id);
	}

	public List<DepartmentPojo> findAllDept() throws Exception {
		return this.idepartmentMapper.findAllDept();
	}


	@Override
	public List<DepartmentPojo> findDeptByMap(HashMap<String, Object> deptParams)
			throws Exception {
		return  this.idepartmentMapper.findDeptByMap(deptParams);
	}
	
}
