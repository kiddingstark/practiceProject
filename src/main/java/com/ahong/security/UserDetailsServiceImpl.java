package com.ahong.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ahong.PO.TRole;
import com.ahong.PO.UserAuthorities;
import com.ahong.service.UserService;

/**
 * 自定义的认证用户获取服务类
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;

	/**
	 * 根据用户名获取认证用户信息
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(StringUtils.isEmpty(username)) {
			throw new UsernameNotFoundException("UserDetailsService没有接收到用户账号");
		} else {
			/**
			 * 根据用户名查找用户信息
			 */
			UserAuthorities authUser = userService.getUserAuthoritiesByUserCode(username);
			if(authUser == null) {
				throw new UsernameNotFoundException(String.format("用户'%s'不存在", username));
			}
			List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
			TRole role = authUser.getRole();
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
			/**
			 * 创建一个用于认证的用户对象并返回，包括：用户名，密码，角色
			 */
			return new User(authUser.getUserCode(), authUser.getPassword(), grantedAuthorities);
		}
	}
}
