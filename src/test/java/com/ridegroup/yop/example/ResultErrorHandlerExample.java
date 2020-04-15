package com.ridegroup.yop.example;

import com.alibaba.fastjson.JSON;

import com.ridegroup.yop.api.PriceNewAPI;
import com.ridegroup.yop.client.LocalHttpClient;
import com.ridegroup.yop.client.ResultErrorHandler;

public class ResultErrorHandlerExample extends ResultErrorHandler{

	@Override
	protected void handle(String uriId, String uri, String requestEntity, Object result) {
		System.out.println("uriId:" + uriId);
		System.out.println("uri:" + uri);
		System.out.println("requestEntity:" + requestEntity);
		System.out.println("result:" + result);
		System.out.println("resultJSON:" + JSON.toJSONString(result));
	}

	
	public static void main(String[] args) {
		//设置数据错误处理
		LocalHttpClient.setResultErrorHandler(new ResultErrorHandlerExample());

		PriceNewAPI.getPrice("","", "");
	}
}
