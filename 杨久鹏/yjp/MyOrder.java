package com.webtest.yjp;


import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;


/**
 * 订单中心 - 我的订单
 * 杨久鹏
 */
public class MyOrder extends BaseTest {
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
	
	
	@Test(description="输入订单编号，查询订单成功")
	public void Enquiry_OrderByID(){
		webtest.type("name=search_key", "201911251556245882");
		webtest.click("xpath=//input[@value='查询']");
		assertTrue(webtest.isTextPresent("vivoX21 6GB+128GB 4G全网通 全面屏 拍照手机 "));
	}
	
	@Test(description="输入商品名称，查询订单成功")
	public void Enquiry_OrderByName(){
		webtest.type("name=search_key", "vivoX21 6GB+128GB 4G全网通 全面屏 拍照手机 ");
		webtest.click("xpath=//input[@value='查询']");
		assertTrue(webtest.isTextPresent("201911251556245882"));
	}
	@Test(description="查询订单失败，输入错误信息")
	public void Enquiry_Fail1(){
		webtest.type("name=search_key", "11");
		webtest.click("xpath=//input[@value='查询']");
		assertTrue(webtest.isTextPresent("201911251556245882"));
	}
	@Test(description="查看订单详情、选择取消订单（未付款）、点击再次购买")
	public void Enquiry_Fail2(){
		
		webtest.type("name=search_key", "201911251434468851");
		webtest.click("xpath=//input[@value='查询']");
		webtest.click("link=查看详情");
		webtest.click("link=取消订单");
		webtest.click("link=确定");
		webtest.click("link=确定");
		webtest.click("link=再次购买");
		assertTrue(webtest.isTextPresent("立即购买"));
	}
	@Test(description="取消已付款但未发货的订单")
	public void cancelOrder1(){
		webtest.type("name=search_key", "201911261039248401");
		webtest.click("xpath=//input[@value='查询']");
		webtest.click("link=查看详情");
		webtest.click("link=取消订单");
		webtest.enterFrame("layui-layer-iframe1");;
		webtest.selectByValue("name=user_note", "操作有误（商品、地址等选错）");
		webtest.type("name=consignee", "yjp");
		webtest.type("name=mobile","15233618965");
		webtest.click("link=确定取消");
		webtest.click("link=取消详情");
		assertTrue(webtest.isTextPresent("取消订单详情"));
	}
	@Test(description="对未付款的订单选择立即付款")
	public void cancelDetail(){
		webtest.type("name=search_key", "201911251556245882");
		webtest.click("xpath=//input[@value='查询']");
		webtest.click("link=立即支付");
		//webtest.click("link=再次购买");
	}	
	@Test
	public void changeState(){
		webtest.click("xpath=//li[contains(text(),'订单状态')]");
		webtest.click("link=已取消");
	}
	
}
