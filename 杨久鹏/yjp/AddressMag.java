package com.webtest.yjp;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class AddressMag extends BaseTest{
	/**
	 * 地址管理
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
	
	@Test(description="修改地址成功")
	public void modify_Success1(){
		webtest.click("link=地址管理");
		webtest.click("xpath=//div[@class='grou_num_list address_list_jl ma-to-20'   ]/ul[2]/li[4]/a[1]");
		webtest.type("name=address", "这是一个修改测试");//详细地址
		webtest.click("xpath=//button[@id='address_submit']");
	}

	@Test(description="设置为默认地址")
	public void setDefault(){
		webtest.click("link=地址管理");
		webtest.click("xpath=//div[@class='grou_num_list address_list_jl ma-to-20']/ul[2]/li[4]/span/a");
		assertTrue(webtest.isTextPresent("默认地址"));
	}
	@Test(description="删除地址")
	public void del(){
		webtest.click("link=地址管理");
		webtest.click("xpath=//div[@class='grou_num_list address_list_jl ma-to-20']/ul[3]/li[4]/a[2]");
		assertTrue(webtest.isElementPresent("xpath=//div[@class='grou_num_list address_list_jl ma-to-20']/ul[3]/li[4]/a[2]"));
	}
}
