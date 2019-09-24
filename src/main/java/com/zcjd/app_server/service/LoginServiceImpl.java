package com.zcjd.app_server.service;


import com.zcjd.app_server.mapper.ILoginMapper;
import com.zcjd.app_server.model.UserInfoPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private ILoginMapper iLoginMapper;
	@Override
	public List<UserInfoPojo> getUserInfoByNumber(Map<String, Object> map)
			throws Exception {
		// TODO Auto-generated method stub
		return iLoginMapper.getUserInfoByNumber(map);
	}

	@Override
	public List<UserInfoPojo> getUserInfoByName(Map<String, Object> map)
			throws Exception {
		// TODO Auto-generated method stub
		return iLoginMapper.getUserInfoByName(map);
	}

}
