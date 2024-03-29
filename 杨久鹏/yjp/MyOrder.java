package com.webtest.yjp;


import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.core.ApiListener;
import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;
import com.webtest.dataprovider.TxtDataProvider;


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
	//1.查询订单成功
	@DataProvider(name = "正确输入")
	public Object[][] getExcelDada1() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel("data-yjp/myOrder.xlsx","Sheet1");
	}
	@Test(description="查询订单成功",dataProvider="正确输入")
	public void Enquiry_Order(String data,String dataAssert){
		
		webtest.type("name=search_key",data);
		webtest.click("xpath=//input[@value='查询']");
		assertTrue(webtest.isTextPresent(dataAssert));
	}

	@DataProvider(name = "错误输入")
	public Object[][] getExcelDada2() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel("data-yjp/myOrder.xlsx","Sheet2");
	}
	@Test(description="查询订单失败，输入错误信息",dataProvider="错误输入")
	public void Enquiry_Fail1(String data,String dataAssert){
		SoftAssert soft =new SoftAssert();
		webtest.type("name=search_key",data);
		webtest.click("xpath=//input[@value='查询']");
		soft.assertTrue(webtest.isTextPresent(dataAssert));
		soft.assertAll();
	}
	
	//4.
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
	//3.
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
		assertTrue(webtest.isTextPresent("订单提交成功，请您尽快付款！"));
	}	
	//5.
	@Test(description="通过交易状态查询订单")
	public void changeState(){
		webtest.click("xpath=//li[contains(text(),'订单状态')]");
		webtest.click("link=已取消");
		assertTrue(webtest.isTextPresent("已取消"));
	}
	
}
