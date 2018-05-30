package com.testfan.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientUtils {

	
    //重载
	public static String doGet(String url) {
		return doGet(url,null);
	}
	
	public static String doGet(String url, Map<String, Object> headparams) {
		
		  //设置代理IP、端口、协议（请分别替换）
	      HttpHost proxy = new HttpHost("127.0.0.1", 8888, "http");

	      //把代理设置到请求配置
	      RequestConfig defaultRequestConfig = RequestConfig.custom()
	              .setProxy(proxy)
	              .build();

	      //实例化CloseableHttpClient对象
	      CloseableHttpClient closeableHttpClient = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();

		// 默认配置，包括连接池
		//CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
		// 构造请求
		HttpGet get = new HttpGet(url);
		
		//非空判断
		if(headparams!=null&&!headparams.isEmpty()) {
			Set<String> keys =headparams.keySet();
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
	
	public static void main(String[] args) {
		String geturl ="http://59.110.139.20:8080/goods/UserServlet?method=loginMobile&loginname=test1&loginpass=test1";
		String result = doGet(geturl);
		System.out.println(result);
	}

}
