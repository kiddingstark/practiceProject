package com.ahong.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ahong.PO.TMenu;
import com.ahong.PO.TMenuExample;
import com.ahong.mapper.TMenuMapper;
import com.ahong.service.CacheService;

@Service
public class CacheServiceImp implements CacheService {

	@Autowired
	private TMenuMapper tMenuMapper;
	


	@Override
	@Cacheable(value="allMenu")
	public List<TMenu> getAllMenu() {
		TMenuExample example = new TMenuExample();
		return tMenuMapper.selectByExample(example);
	}
	
	@Cacheable(value="menuInfo",key="'menu:' + #id")
	public TMenu getMenuById(String id) {
		TMenuExample example = new TMenuExample();
		TMenuExample.Criteria c = example.createCriteria();
		c.andMenuIdEqualTo(id);
		List<TMenu> list = tMenuMapper.selectByExample(example);
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
