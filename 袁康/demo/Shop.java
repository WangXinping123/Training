package com.webtest.demo;

import org.testng.annotations.BeforeClass;

public class Shop extends Admin_Login{
	@BeforeClass
	public void goSetting(){
		webtest.click("xpath=//a[contains(text(), 'илЁг')]");
	}
}
