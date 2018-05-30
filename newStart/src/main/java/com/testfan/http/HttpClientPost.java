package com.testfan.http;

import java.io.IOException;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.util.*;

public class HttpClientPost {
	
	 //设置代理IP、端口、协议（请分别替换）
    private static HttpHost proxy = new HttpHost("127.0.0.1", 8888, "http");

    //把代理设置到请求配置ss
    private static RequestConfig defaultRequestConfig = RequestConfig.custom()
            .setProxy(proxy)
            .build();

    //实例化CloseableHttpClient对象
    private static CloseableHttpClient closeableHttpClient = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();

	// 重载
	public static String doGet(String url) {
		return doGet(url, null);
	}

	public static String doGet(String url, Map<String, Object> headparams) {
		
        
		// 默认配置，包括连接池
		//CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
		// 构造请求
		HttpGet get = new HttpGet(url);

		// 头部处理
		if (headparams != null && !headparams.isEmpty()) {
			Set<String> keys = headparams.keySet();
			for (String key : keys) {
				get.addHeader(key, headparams.get(key).toString());
			}
		}

		String result = "";
		HttpEntity entity = null;
		try {
			CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(get);
			entity = closeableHttpResponse.getEntity();
			result = EntityUtils.toString(entity, "utf-8");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				EntityUtils.consume(entity);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static String doPost(String url, Map<String, Object> headparams, Map<String, Object> postparams) {
		// 构造请求
		HttpPost post = new HttpPost(url);
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		if(postparams != null && !postparams.isEmpty()) {
			for (String key: postparams.keySet()) {
				list.add(new BasicNameValuePair(key, postparams.get(key).toString()));
			}
		}

		UrlEncodedFormEntity postentity = new UrlEncodedFormEntity(list, Consts.UTF_8);  
		
		post.setEntity(postentity);
		
		// 头部处理
		if (headparams != null && !headparams.isEmpty()) {
			Set<String> keys = headparams.keySet();
			for (String key : keys) {
				post.addHeader(key, headparams.get(key).toString());
			}
		}

		String result = "";
		HttpEntity entity = null;
		try {
			CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(post);
			entity = closeableHttpResponse.getEntity();
			result = EntityUtils.toString(entity, "utf-8");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				EntityUtils.consume(entity);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	

	public static String doPostJson(String url, String jsonParam, Map<String, Object> headparams) {
		// 构造请求
		HttpPost post = new HttpPost(url);

		// 参数封装
		if (jsonParam != null) {
			StringEntity json_entity = new StringEntity(jsonParam.toString(), "utf-8");// 解决中文乱码问题
			json_entity.setContentEncoding("UTF-8");
			json_entity.setContentType("application/json");
			post.setEntity(json_entity);
		}

		// 头部处理
		if (headparams != null && !headparams.isEmpty()) {
			Set<String> keys = headparams.keySet();
			for (String key : keys) {
				post.addHeader(key, headparams.get(key).toString());
			}
		}

		String result = "";
		HttpEntity entity = null;
		try {
			CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(post);
			entity = closeableHttpResponse.getEntity();
			result = EntityUtils.toString(entity, "utf-8");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				EntityUtils.consume(entity);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String geturl = "http://59.110.139.20:8080/goods/UserServlet?method=loginMobile&loginname=test1&loginpass=test1";
		String result = doGet(geturl);
		System.out.println(result);
		
		Map<String, Object> headparams = new HashMap<String, Object>();
		headparams.put("token", "123456");
		 result = doGet(geturl,headparams);
		 System.out.println(result);
		 
		 Map<String, Object> postparams = new HashMap<String, Object>();
		 postparams.put("method","loginMobile");
		 postparams.put("loginname","test1");
		 postparams.put("loginpass","test1");
		 result = doPost("http://59.110.139.20:8080/goods/UserServlet",null, postparams);
		 System.out.println(result);
		 
		//测试json
		 headparams = new HashMap<String, Object>();
		 headparams.put("token", "61b3590090982a0185dda9d3bd793b46");
		doPostJson("http://59.110.139.20:8080/goods/json2", "{\"count\":10}",headparams);
		
	}

}
