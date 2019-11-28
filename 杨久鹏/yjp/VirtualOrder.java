package com.webtest.yjp;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class VirtualOrder extends BaseTest{
	static public String url="http://localhost:8036/";
	
	Login action;
	
	@BeforeClass(description="登录")
	public void setup()
	{
		action=new Login(webtest);
		webtest.open(url);
		action.login("13800138006", "123456");
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[1]/li[2]/a");

	}
	

	@Test(description="收货确认，评价商品，匿名进行评价成功")
	public void selectOrder(){
		webtest.click("link=虚拟订单");
		webtest.type("name=search_key", "201911261359351951");
		webtest.click("xpath=//input[@value='查询']");
		assertTrue(webtest.isTextPresent("广西移动官方"));
		webtest.click("link=收货确认");
		webtest.click("link=是");
		webtest.click("xpath=//button[contains(text(),'评价')]");
		webtest.click("xpath=//span[@id='goods_rank']/img[5]");
		webtest.click("link=评价");
		webtest.click("xpath=//span[@id='goods_rank']/img[5]");
		webtest.click("xpath=//span[@id='service_rank']/img[5]");
		webtest.type("name=content", "这是一个商品评价，同时是可以做参数化的地方！");
		webtest.click("xpath=//input[@name='hide_username']");
		webtest.click("xpath=//button[contains(text(),'提交')]");
		assertTrue(webtest.isTextPresent("您还没有订单，快去逛逛吧~"));
	}
	@Test(description="评价商品失败，未进行打分")
	public void assessOrder_Fail1(){
		webtest.click("link=虚拟订单");
		webtest.type("name=search_key", "201911251638159786");
		webtest.click("xpath=//input[@value='查询']");
		assertTrue(webtest.isTextPresent("广西移动官方"));
		webtest.click("link=评价");
		webtest.type("name=content", "这是一个商品评价，同时是可以做参数化的地方！");
		webtest.click("xpath=//input[@name='hide_username']");
		webtest.click("xpath=//button[contains(text(),'提交')]");
		assertTrue(webtest.isTextPresent("您还没有订单，快去逛逛吧~"));
	}
	@Test(description="评价商品失败，未进行内容评价")
	public void assessOrder_Fail2(){
		webtest.click("link=虚拟订单");
		webtest.type("name=search_key", "201911251638159786");
		webtest.click("xpath=//input[@value='查询']");
		assertTrue(webtest.isTextPresent("广西移动官方"));
		webtest.click("link=评价");
		webtest.click("xpath=//span[@id='goods_rank']/img[5]");
		webtest.click("xpath=//span[@id='service_rank']/img[5]");
		webtest.type("name=content", " ");
		webtest.click("xpath=//input[@name='hide_username']");
		webtest.click("xpath=//button[contains(text(),'提交')]");
		assertTrue(webtest.isTextPresent("您还没有订单，快去逛逛吧~"));
	}
	@Test(description="虚拟订单，点击查看详情")
	public void OrderDetail(){
		webtest.click("link=虚拟订单");
		webtest.type("name=search_key", "201911251638159786");
		webtest.click("xpath=//input[@value='查询']");
		webtest.click("link=查看详情");
		assertTrue(webtest.isTextPresent("虚拟订单信息 "));
		//webtest.click("link=再次购买");
	}
	@Test(description="未付款订单取消订单/立即支付")
	public void cancelOrder(){
		webtest.click("link=虚拟订单");
		webtest.type("name=search_key", "201911261432319040");
		webtest.click("xpath=//input[@value='查询']");
		webtest.click("link=查看详情");
		webtest.click("xpath=//button[contains(text(),'取消订单')]");		
		webtest.click("link=是");
		webtest.click("link=确定");
//		webtest.click("xpath=//button[contains(text(),'立即支付')]");
//		webtest.click("link=确认支付方式");
	}
	
	@Test(description="输入订单编号，查询订单成功")
	public void Enquiry_OrderByID(){
		webtest.click("link=虚拟订单");
		webtest.type("name=search_key", "201811131702529592");
		webtest.click("xpath=//input[@value='查询']");
		assertTrue(webtest.isTextPresent("广东联通官方充值全国手机话费100元快速到账自动充值"));
	}
//	
	@Test(description="输入商品名称，查询订单成功")
	public void Enquiry_OrderByName(){
		webtest.click("link=虚拟订单");
		webtest.type("name=search_key", "广东联通官方充值全国手机话费100元快速到账自动充值 ");
		webtest.click("xpath=//input[@value='查询']");
		assertTrue(webtest.isTextPresent("201811131702529592"));
	}
//	
	@Test(description="查询订单失败，输入错误信息")
	public void Enquiry_Fail(){
		webtest.click("link=虚拟订单");
		webtest.type("name=search_key", "111");
		webtest.click("xpath=//input[@value='查询']");
		assertTrue(webtest.isTextPresent("查询失败"));
	}

}
