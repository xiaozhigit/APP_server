package com.zcjd.app_server.service;

import com.zcjd.app_server.mapper.ICoderuleMapper;
import com.zcjd.app_server.mapper.IUserMapper;
import com.zcjd.app_server.model.CoderulePojo;
import com.zcjd.app_server.model.UserInfoAccountPojo;
import com.zcjd.app_server.model.UserInfoPojo;
import com.zcjd.app_server.model.UserTreePojo;
import com.zcjd.app_server.util.CreateNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private IUserMapper mapper;
	
	@Autowired
	private ICoderuleMapper codeMapper;

	public List<UserInfoPojo> findUserByPage(HashMap<String, Object> params) throws Exception{
		List<UserInfoPojo> userList = this.mapper.findUserByPage(params);		
		return userList;
	}


	public void saveUser(UserInfoPojo pojo) throws Exception{		  
		this.mapper.saveUser(pojo);
	
	}



	public void updateUser(UserInfoPojo pojo)throws Exception {		
		this.mapper.updateUser(pojo);
	}

	

	public UserInfoPojo getUserById(String id) throws Exception{		
		return this.mapper.getUserById(id);
	}


	public void deleteUser(String id)throws Exception {
		this.mapper.deleteUser(id);
		
	}


	public List<UserInfoPojo> selectUserLike(HashMap<String, Object> params) {
		return this.mapper.selectUserLike(params);
	}


	public List<UserTreePojo> findAllUser() throws Exception {
		return this.mapper.findAllUser();
	}


	@Override
	public void updateResigningUser(UserInfoPojo user) throws Exception {
		mapper.resigningUser(user);
	}


	public List<UserInfoAccountPojo> findUserInfoAccountByPage(
			HashMap<String, Object> params) throws Exception {
		return this.mapper.findUserInfoAccountByPage(params);
	}


	//获取编号
	@Override
	public String getContractNumberList(String codeId) throws Exception {	
		CoderulePojo coderule = codeMapper.getCoderuleById(codeId);
		List<String> number_list = mapper.getUserNumberList();//得到所有合同编号
		String code = "";
		if(coderule != null){
			code = CreateNumber.productNumber(coderule,number_list);
		}
		return code;	
	}

	@Override
	public void updateUserInfoAccountState(HashMap<String, Object> params) throws Exception {
		this.mapper.updateUserInfoAccountState(params);
	}

	
}