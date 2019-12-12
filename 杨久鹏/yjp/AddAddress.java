package com.webtest.yjp;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.webtest.core.ApiListener;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;

public class AddAddress extends BaseTest{
	/**
	 * 添加地址
	 */
	static public String url="http://localhost:8036/";
	
	Login action;
	
	@BeforeClass(description="登录")
	public void setup()
	{
		action=new Login(webtest);
		webtest.open(url);
		action.login("13800138006 ", "123456");
		webtest.click("link=地址管理");
		webtest.click("xpath=//span[contains(text(),'增加新地址')]");
	}
	
	@DataProvider(name = "成功添加")
	public Object[][] getExcelDada1() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel("data-yjp/address.xlsx","Sheet1");
	}
	@Test(description="成功添加一条新地址",dataProvider="成功添加")
	public void addAddress_Success(String consignee,String mobile,String province,String city,String district,String twon
			,String address,String zipcode,String dataAssert){
		SoftAssert soft =new SoftAssert();
		
		webtest.type("name=consignee", consignee);//收货人
		webtest.type("name=mobile", mobile);//手机或固定电话
		//收货地址的Select标签
		webtest.selectByVisibleText("name=province", province);
		webtest.selectByVisibleText("name=city", city);
		webtest.selectByVisibleText("name=district", district);
		webtest.selectByVisibleText("name=twon", twon);
		webtest.type("name=address", address);//详细地址
		webtest.type("name=zipcode", zipcode);//邮编
		webtest.click("xpath=//button[@id='address_submit']");
		soft.assertTrue(webtest.isTextPresent(dataAssert));
		soft.assertAll();
	}

	@DataProvider(name = "缺少必填信息")
	public Object[][] getExcelDada2() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel("data-yjp/address.xlsx","Sheet2");
	}
	@Test(description="增加新地址失败，缺少必填信息",dataProvider="缺少必填信息")
	public void addAddress_Fail1(String consignee,String mobile,String province,String city,String district,String twon
			,String address,String zipcode,String dataAssert) throws InterruptedException{
		SoftAssert soft =new SoftAssert();
//		webtest.click("link=地址管理");
//		webtest.click("xpath=//span[contains(text(),'增加新地址')]");
		webtest.type("name=consignee", consignee);//收货人
		webtest.type("name=mobile", mobile);//手机或固定电话
		//收货地址的Select标签
		webtest.selectByVisibleText("name=province", province);
		webtest.selectByVisibleText("name=city", city);
		webtest.selectByVisibleText("name=district", district);
		webtest.selectByVisibleText("name=twon", twon);
		webtest.type("name=address", address);//详细地址
		webtest.type("name=zipcode", zipcode);//邮编
		webtest.click("xpath=//button[@id='address_submit']");
		Thread.sleep(1000);
		soft.assertTrue(webtest.isTextPresent(dataAssert));
		soft.assertAll();
	}
	

	@DataProvider(name = "手机或固定电话格式错误")
	public Object[][] getExcelDada3() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel("data-yjp/address.xlsx","Sheet3");
	}
	@Test(description="增加新地址失败，手机或固定电话格式错误",dataProvider="手机或固定电话格式错误")
	public void addAddress_Fail2(String consignee,String mobile,String province,String city,String district,String twon
			,String address,String zipcode,String dataAssert) throws InterruptedException{
		SoftAssert soft =new SoftAssert();
//		webtest.click("link=地址管理");
//		webtest.click("xpath=//span[contains(text(),'增加新地址')]");
		webtest.type("name=consignee", consignee);//收货人
		webtest.type("name=mobile", mobile);//手机或固定电话
		//收货地址的Select标签
		webtest.selectByVisibleText("name=province", province);
		webtest.selectByVisibleText("name=city", city);
		webtest.selectByVisibleText("name=district", district);
		webtest.selectByVisibleText("name=twon", twon);
		webtest.type("name=address", address);//详细地址
		webtest.type("name=zipcode", zipcode);//邮编
		webtest.click("xpath=//button[@id='address_submit']");
		Thread.sleep(1000);
		soft.assertTrue(webtest.isTextPresent(dataAssert));
		soft.assertAll();
	}

	

}
