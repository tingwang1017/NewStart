package com.test.http;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClientUtils_o {

	public static void main(String[] args) {
		CloseableHttpClient closeableHttpClient= HttpClients.createDefault();
		
		HttpPost post = new HttpPost("http://59.110.139.20:8080/goods/UserServlet?method=loginMobile&loginname=test1&loginpass=test1");
		HttpEntity entity = null;
		try {
			CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(post);
			entity = closeableHttpResponse.getEntity();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
