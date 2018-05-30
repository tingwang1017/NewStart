package com.testfan.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.text.html.parser.Entity;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class HttpClientBaidu {
	
	public static void httpClientBaidu() {
		
		
		  //设置代理IP、端口、协议（请分别替换）
      HttpHost proxy = new HttpHost("127.0.0.1", 8888, "http");

      //把代理设置到请求配置
      RequestConfig defaultRequestConfig = RequestConfig.custom()
              .setProxy(proxy)
              .build();

      //实例化CloseableHttpClient对象
      CloseableHttpClient closeableHttpClient = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();

		//默认配置，包括连接池
		//CloseableHttpClient closeableHttpClient= HttpClients.createDefault();
		
		//构造请求
		HttpGet get = new HttpGet("http://www.baidu.com");
		
		   BufferedReader in = null;
	        String result = "";
	        HttpEntity entity = null;
		try {
			CloseableHttpResponse closeableHttpResponse =closeableHttpClient.execute(get);
			
			entity = closeableHttpResponse.getEntity();
			//第一种结果处理
/*			  in = new BufferedReader(
	                    new InputStreamReader(entity.getContent()));
	            String line;
	            while ((line = in.readLine()) != null) {
	            	result += line;
	            }
			
	            */
			
			result = EntityUtils.toString(entity);
	            System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				EntityUtils.consume(entity);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		
		HttpClientBaidu.httpClientBaidu();
		

	}

}
