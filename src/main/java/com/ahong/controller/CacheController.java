package com.ahong.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.ahong.PO.TMenu;
import com.ahong.service.CacheService;

@RequestMapping("/cache")
@Controller
public class CacheController {

	private static final Log log = LogFactory.getLog(CacheController.class);
	@Autowired
	private CacheService cacheService;
	
	@RequestMapping("/getAllMenu")
	@ResponseBody
	public ModelAndView getAllMenu(HttpSession session, HttpServletRequest request){
		Map<String, Object> map = new HashMap<>();
		try{
			map.put("data",cacheService.getAllMenu());
			map.put("message","OK");
			map.put("code","0");
		}catch (Exception e){
			log.error("error:"+e.getMessage());
			map.put("message",e.getMessage());
			map.put("code","1");
		}
		return new ModelAndView(new MappingJackson2JsonView(), map);
	}
	
	@RequestMapping("/getMenuById")
	@ResponseBody
	public ModelAndView getMenuById(String id, HttpSession session, HttpServletRequest request){
		Map<String, Object> map = new HashMap<>();
		try{
			map.put("data",cacheService.getMenuById(id));
			map.put("message","OK");
			map.put("code","0");
		}catch (Exception e){
			log.error("error:"+e.getMessage());
			map.put("message",e.getMessage());
			map.put("code","1");
		}
		return new ModelAndView(new MappingJackson2JsonView(), map);
	}
	
}
