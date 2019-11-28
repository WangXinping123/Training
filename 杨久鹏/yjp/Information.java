package com.webtest.yjp;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

/**
 * 个人信息
 * @author yjp
 *
 */
public class Information extends BaseTest{
	static public String url="http://localhost:8036/";
	
	Login action;
	
	@BeforeClass(description="登录")
	public void setup()
	{
		action=new Login(webtest);
		webtest.open(url);
		action.login("13800138006", "123456");
		webtest.click("link=个人信息");
		
	}
	
	@Test(description="修改个人信息成功")
	public void modify_Success1(){
		// 有问题
		webtest.click("xpath=//img[@id='preview']");
		//webtest.enterFrame("layui-layer4");
		webtest.type("xpath=//input[type='file']", "F:\\水形物语.jpg");
		webtest.type("name=nickname", "测试账号VIP");
		webtest.click("xpath=//input[name='sex',value='1']");
		webtest.type("name=birthday", "1999-10-04");
		webtest.click("xpath=//input[@value='确认保存']");
		assertTrue(webtest.isTextPresent("操作成功"));
	}
	
	@Test(description="修改昵称为空或空格")
	public void modify_Name(){
		webtest.type("name=nickname", " ");
		webtest.click("xpath=//input[@value='确认保存']");
		assertTrue(webtest.isTextPresent("操作失败"));
	}
	
	@Test(description="清空生日保存")
	public void modify_Birthday1(){
		webtest.type("name=birthday", " ");
		webtest.click("xpath=//input[@value='确认保存']");
		assertTrue(webtest.isTextPresent("操作失败"));
	}
	
	@Test(description="生日设置不合法")
	public void modify_Birthday2(){
		webtest.type("name=birthday", "2099-13-32");
		webtest.click("xpath=//input[@value='确认保存']");
		assertTrue(webtest.isTextPresent("操作失败"));
	}

	@Test(description="更换绑定手机成功")
	public void Bind_Phone(){
		webtest.click("link=更换绑定");
		webtest.type("name=code", "'1=1");//SQL注入方式绕过验证
		webtest.click("xpath=//button[contains(text(),'下一步')]");
		webtest.type("name=mobile", "13800138006");
		webtest.type("name=code", "'1=1");
		webtest.click("xpath=//button[contains(text(),'确定修改')]");
		assertTrue(webtest.isTextPresent("修改成功"));
	}
	
	@Test(description="绑定邮箱成功")
	public void modify_Success(){
		webtest.click("link=未绑定");
		webtest.type("name=email", "987580132@qq.com");
		webtest.type("name=code", "'1=1");
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("绑定成功"));
	}
	@Test(description="跳转到安全设置")
	public void goToSecurity(){
		webtest.click("link=个人信息");
		webtest.click("link=安全设置");
		assertTrue(webtest.isTextPresent("互联网账号存在被盗风险，建议您定期更改密码以及保护账户安全。"));
	}
}
