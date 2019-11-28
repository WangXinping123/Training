package com.webtest.yjp;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class SecuritySet extends BaseTest{
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
	
	@Test(description="更改登录密码成功")
	public void changePsw_Success(){
		webtest.click("link=安全设置");

	}
//	@Test(description="更改登录密码失败，未输入信息")
//	public void changePsw_Fail1(){
//		
//	}
//	@Test(description="更改登录密码失败，原密码输入错误")
//	public void changePsw_Fail2(){
//		
//	}
//	@Test(description="更改登录密码失败，新密码不符合要求")
//	public void changePsw_Fail3(){
//		
//	}
//	@Test(description="更改登录密码失败，两次密码输入不一致")
//	public void changePsw_Fail4(){
//		
//	}
	@Test(description="更改手机验证失败，新手机号位数不足")
	public void phoneCheck_Fail1(){
		webtest.click("link=已验证(点击修改)");
		webtest.type("name=code", "'1=1");//SQL注入方式绕过验证
		webtest.click("xpath=//button[contains(text(),'下一步')]");
		webtest.type("name=mobile", "110");
		webtest.type("name=code", "'1=1");
		webtest.click("xpath=//button[contains(text(),'确定修改')]");
		assertTrue(webtest.isTextPresent("新手机格式错误"));
	}
	@Test(description="更改手机验证失败，新手机号输入为中文")
	public void phoneCheck(){
		webtest.click("link=已验证(点击修改)");
		webtest.type("name=code", "'1=1");//SQL注入方式绕过验证
		webtest.click("xpath=//button[contains(text(),'下一步')]");
		webtest.type("name=mobile", "测试");
		webtest.type("name=code", "'1=1");
		webtest.click("xpath=//button[contains(text(),'确定修改')]");
		assertTrue(webtest.isTextPresent("新手机格式错误"));
	}
}
