package com.edu.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.ParseException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.edu.core.ApiListener;
import com.edu.core.HttpDriver;

@Listeners(ApiListener.class)
public class Demo1 {
	@Test
	//登录状态，正常查询
	public void test1() throws ParseException, IOException {
		Map<String, Object> fee_para=new HashMap<String, Object>();
		fee_para.put("id", "1");
		fee_para.put("address","浙江省_杭州市_滨江区");
		fee_para.put("login", 1);
		String fee_result=HttpDriver.doGet("get/with/param/", fee_para);
		System.out.println(fee_result);
	}
	@Test
	//非登录状态
	public void test2() throws ParseException, IOException {
		Map<String, Object> fee_para=new HashMap<String, Object>();
		fee_para.put("id", "1");
		fee_para.put("address","浙江省_杭州市_滨江区");
		fee_para.put("login", 0);
		String fee_result=HttpDriver.doGet("get/with/param/", fee_para);
		System.out.println(fee_result);
	}
	@Test
	//登录状态，查询不存在
	public void test3() throws ParseException, IOException {
		Map<String, Object> fee_para=new HashMap<String, Object>();
		fee_para.put("id", "1");
		fee_para.put("address","123123");
		fee_para.put("login", 1);
		String fee_result=HttpDriver.doGet("get/with/param/", fee_para);
		System.out.println(fee_result);
	}

	

}
