package com.ahong.service;

import java.util.List;

import com.ahong.PO.TMenu;

public interface CacheService {

	List<TMenu> getAllMenu();
	
	TMenu getMenuById(String id);

}
