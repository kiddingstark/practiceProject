package com.ahong.PO;

import java.util.List;

public class TUserAuthorities extends TUser {
	
	private TRole role;
	
	private List<TMenu> menuList;
	
	public TRole getRole() {
		return role;
	}
	public void setRole(TRole role) {
		this.role = role;
	}
	public List<TMenu> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<TMenu> menuList) {
		this.menuList = menuList;
	}
	
	

}
