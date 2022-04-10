package com.ahong.mapper;


import com.ahong.PO.UserAuthorities;

public interface TUserAuthoritiesMapper {
	
	public UserAuthorities getUserAuthoritiesByUserCode(String userCode);
	
}