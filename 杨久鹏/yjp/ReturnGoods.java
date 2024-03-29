package com.webtest.yjp;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.ApiListener;
import com.webtest.core.BaseTest;

public class ReturnGoods extends BaseTest{
	/**
	 * 退货管理
	 */
	static public String url="http://localhost:8036/";
	
	Login action;
	
	@BeforeClass(description="登录")
	public void setup()
	{
		action=new Login(webtest);
		webtest.open(url);
		action.login("13800138006", "123456");
		for(int i=1;i<5;i++){
			webtest.downClick();
		}	
		webtest.click("link=退货管理");
	}
	
	@Test(description="在输入框输入订单编号搜索成功")
	public void select_Success(){
		webtest.type("name=search_key","201912021939578243");
		webtest.click("xpath=//i[@class='litt-sexx']");
		assertTrue(webtest.isTextPresent("83"));
	}
	@Test(description="在输入框输入订单编号搜索失败")
	public void select_Fail1(){
		webtest.type("name=search_key","2019");
		webtest.click("xpath=//i[@class='litt-sexx']");
		assertTrue(webtest.isTextPresent(" 您还没有要处理的订单，快去逛逛吧~ "));
	}
	@Test(description="在输入框输入订单编号搜索失败")
	public void select_Fail2(){
		webtest.type("name=search_key","测试");
		webtest.click("xpath=//i[@class='litt-sexx']");
		assertTrue(webtest.isTextPresent(" 您还没有要处理的订单，快去逛逛吧~ "));
	}
}
