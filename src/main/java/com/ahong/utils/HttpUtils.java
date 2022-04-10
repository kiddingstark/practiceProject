package com.ahong.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

/**
 * http协议的POST、GET方式调用第三方接口
 * @author zhengruihong
 *
 */
public class HttpUtils {
	
	private static Logger log = Logger.getLogger(HttpUtils.class);

	/**
	 * 通过http协议的post方式调用接口获得数据
	 * @param url
	 * @param paramsMap：参数Map
	 * @return json数据
	 * @throws Exception 
	 */
	public static String doPost(String url,Map<String,Object> paramsMap) throws Exception{
	    CloseableHttpClient httpClient = HttpClients.createDefault();
		log.info("------Post URL:"+url);
		HttpPost httpPost = new HttpPost(url);
	    HttpEntity httpentity = null;
	    CloseableHttpResponse response = null;
		try {
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			if(paramsMap != null){
				for (Map.Entry<String, Object> entry : paramsMap.entrySet()) { 
					params.add(new BasicNameValuePair(entry.getKey(),entry.getValue().toString()));
				}
			}
			httpentity = new UrlEncodedFormEntity(params, "UTF-8");
			httpPost.setEntity(httpentity);
			// 添加请求头信息
	        // 浏览器表示
			httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.7.6)");
	        // 传输的类型
			httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
			response = httpClient.execute(httpPost);
			log.info("------response:"+response.toString());
			if(response.getStatusLine().getStatusCode() != 200){
				log.error("The connection fails,Url:"+url);
				throw new Exception("The connection fails,error code:"+response.getStatusLine().getStatusCode());
			}
			String retData = EntityUtils.toString(response.getEntity(), "UTF-8");
			return retData;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (null != response) {
	            try {
	                response.close();
	                httpClient.close();
	            } catch (IOException e) {
	                System.err.println("释放连接出错");
	                e.printStackTrace();
	            }
	        }

		}
		return "";  
	}
	
	/**
	 * 通过http协议的get方式调用接口获得数据
	 * @param url
	 * @param paramsMap：参数Map
	 * @return json数据
	 * @throws Exception 
	 */
	public static String doGet(String url,Map<String, Object> paramsMap) throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		log.info("------Get URL:"+url);
	    try {
	        URIBuilder uriBuilder = new URIBuilder(url);
	        if(paramsMap != null){
				for (Entry<String, Object> entry : paramsMap.entrySet()) { 
					uriBuilder.addParameter(entry.getKey(), entry.getValue().toString());
				}
			}
	        HttpGet httpGet = new HttpGet(uriBuilder.build());
	        // 添加请求头信息
	        // 浏览器表示
	        httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.7.6)");
	        // 传输的类型
	        httpGet.addHeader("Content-Type", "application/x-www-form-urlencoded");
	        response = httpClient.execute(httpGet);
	        log.info("------response:"+response.toString());
	        if(response.getStatusLine().getStatusCode() != 200){
				log.error("The connection fails,Url:"+url);
				throw new Exception("The connection fails,error code:"+response.getStatusLine().getStatusCode());
			}
			String retData = EntityUtils.toString(response.getEntity(), "UTF-8");
			return retData;
	    } catch (ClientProtocolException e) {
	        e.printStackTrace();
	    } catch (ParseException e) {
	        e.printStackTrace();
	    } catch (URISyntaxException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }finally{
	    	if (null != response) {
	            try {
	                response.close();
	                httpClient.close();
	            } catch (IOException e) {
	                System.err.println("释放连接出错");
	                e.printStackTrace();
	            }
	        }
	    }
	    return "";
	}
}
