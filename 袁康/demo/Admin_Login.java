package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Admin_Login  extends BaseTest{
	
	@BeforeClass
	public static void testLogin() {
		//打开页面
		webtest.open("http://localhost:8036/index.php/Admin/Admin/login");
		//文本框输入
		webtest.type("name=username", "admin");
		webtest.type("name=password", "admin123");
		webtest.click("xpath=//input[@type='button']");
		assertTrue(webtest.isTextPresent("admin"));
	}

}
