package com.ahong.controller;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
/**
 * springmvc上传文件
 * @author zhengruihong
 *
 */
@Controller
@RequestMapping("/file")
public class FileController {
	
	private static final String FILEPATH = "d://file";
	private static Logger log = Logger.getLogger(FileController.class);
	
	@RequestMapping("/uploadfile")
	@ResponseBody
	public ModelAndView uploadFile(HttpServletRequest request,Model model,@RequestParam("files")MultipartFile[] files) throws FileUploadException{
		Map<String, Object> map = new HashMap<>();
		if(files != null && files.length>0){
			for(MultipartFile file: files){
				File targetFile = new File(UUID.randomUUID()+file.getOriginalFilename().substring(file.getOriginalFilename().indexOf(".")));
				if(!targetFile.exists()) {
					targetFile.mkdir();
				}
				try {
					file.transferTo(targetFile);
					log.info("文件上传成功："+targetFile);
					map.put("message","OK");
					map.put("code","0");
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
					log.error("error:"+e.getMessage());
					map.put("message",e.getMessage());
					map.put("code","1");
					break;
				}
			}
		}
		return new ModelAndView(new MappingJackson2JsonView(), map);
	}
}
