package com.webtest.demo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Setting extends Admin_Login{
	@BeforeClass
	public void goSetting(){
		webtest.click("xpath=//a[contains(text(), '…Ë÷√')]");
	}
	@Test
	public void note(){
		webtest.click("xpath=//a[@data-param='index|SmsTemplate']");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@class='fbutton']");
	}
}
