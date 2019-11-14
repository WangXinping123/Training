package com.edu.test;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Checker;

public class SkulistTest {
	String skulist_url="/common/skuList";
	Checker checker = null;
	
	public void getSkulist() throws Exception {
		String result = HttpDriver.doGet(skulist_url);
		checker=new Checker(result);
	}

	public void getSkulistByPara(Map<String,Object> para) throws Exception {
		String result = HttpDriver.doGet(skulist_url);
		checker=new Checker(result);
	}
	
	@Test
	public void test1() throws Exception{
		Map<String, Object> skuid = new HashMap<String, Object>();
		skuid.put("goodsId", "1");
		getSkulistByPara(skuid);
		checker.verifyXpath("code", "200");
	}
	
	@Test
	public void test2() throws Exception{
		getSkulist();
		checker.verifyXpath("code", "200");
	}
}
