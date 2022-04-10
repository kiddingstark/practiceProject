package com.ahong.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

/**
 * Servlet上传文件
 * @author zhengruihong
 *
 */
@WebServlet("/FileServlet")
public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String FILEPATH = "d://file";
	private static Logger log = Logger.getLogger(FileServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);   
		if (isMultipart) {
			String fileName = "",newFileName = "",fieldName = "";
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(factory);
			sfu.setHeaderEncoding("UTF-8");
			List<FileItem> fileList  =null;
			try {
				fileList = sfu.parseRequest(request);
			} catch (FileUploadException e1) {
				e1.printStackTrace();
			}
			if(fileList != null && fileList.size()>0){
				//创建文件报保存目录
				File filePath = new File(FILEPATH);
				if(!filePath.exists()){
					filePath.mkdir();
				}
				for(FileItem file:fileList){
					fileName = file.getName();
					fieldName = file.getFieldName();
					newFileName = DateTimeUtils.formatDate(new Date())+fileName.substring(fileName.indexOf("."));
					File allFilePath = new File(filePath,newFileName);
					try {
						file.write(allFilePath);
					} catch (Exception e) {
						System.err.println("文件上传出错："+e);
					}
					log.info("文件上传成功，路径："+allFilePath);
					response.getWriter().print("文件上传成功");
				}
			}
		}
	}
}
