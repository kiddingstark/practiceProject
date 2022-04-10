package com.ahong.service;

import com.ahong.PO.User;
import com.ahong.PO.UserAuthorities;

public interface UserService {

	User login(String userCode, String password);
	
	UserAuthorities getUserAuthoritiesByUserCode(String userCode);


}
