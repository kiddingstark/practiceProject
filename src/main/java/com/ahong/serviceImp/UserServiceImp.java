package com.ahong.serviceImp;

import com.ahong.PO.TUserExample;
import com.ahong.PO.User;
import com.ahong.PO.UserAuthorities;
import com.ahong.enums.ResponseEnum;
import com.ahong.exception.ApplicationException;
import com.ahong.mapper.TUserAuthoritiesMapper;
import com.ahong.mapper.TUserMapper;
import com.ahong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private TUserMapper tUserMapper;
	
	@Autowired
	private TUserAuthoritiesMapper tUserAuthoritiesMapper;

	@Override
	public User login(String userCode, String password) {
		TUserExample example = new TUserExample();
		TUserExample.Criteria c = example.createCriteria();
		c.andUserCodeEqualTo(userCode);
		c.andPasswordEqualTo(password);
		List<User> userList =  tUserMapper.selectByExample(example);
		if(userList == null || userList.size() == 0){
			throw new ApplicationException(ResponseEnum.FAIL.getCode(),"用户名或密码错误！");
		}
		return userList.get(0);
	}

	@Override
	public UserAuthorities getUserAuthoritiesByUserCode(String userCode) {
		return tUserAuthoritiesMapper.getUserAuthoritiesByUserCode(userCode);
	}

}
