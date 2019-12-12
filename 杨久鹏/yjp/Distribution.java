package com.webtest.yjp;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Distribution extends BaseTest{
	/**
	 * 分销中心(我的推广、我的收益)
	 */
	static public String url="http://localhost:8036/";
	
	Login action;
	
	@BeforeClass(description="登录")
	public void setup()
	{
		action=new Login(webtest);
		webtest.open(url);
		action.login("13800138006 ", "123456");

	}
	@Test(description="选择一个会员，点击查看返利订单")
	public void rebate(){
		webtest.click("link=我的推广");
		webtest.click("xpath=//div[@class='menumain p']/div[2]/div[4]/ul/li[6]/div/p/a");
		assertTrue(webtest.isTextPresent("您还没有分销订单"));
	}
	
	@Test(description="选择三级下线，点击快去邀请好友")
	public void invitation(){
		webtest.click("link=我的推广");
		webtest.click("link=三级下线");
		webtest.click("link=快去邀请好友吧~");
		assertTrue(webtest.isTextPresent("邀请"));
	}
	
	@Test(description="在订单编号查询的输入框中输入")
	public void input(){
		webtest.click("link=我的收益");
		webtest.type("name=order_sn", "11");
		webtest.click("xpath=//i[@class='litt-sexx']");
		assertTrue(webtest.isTextPresent("11"));
	}
}
