package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Admin_Login  extends BaseTest{
	
	@BeforeClass
	public static void testLogin() {
		//��ҳ��
		webtest.open("http://localhost:8036/index.php/Admin/Admin/login");
		//�ı�������
		webtest.type("name=username", "admin");
		webtest.type("name=password", "admin123");
		webtest.click("xpath=//input[@type='button']");
		assertTrue(webtest.isTextPresent("admin"));
	}

}
