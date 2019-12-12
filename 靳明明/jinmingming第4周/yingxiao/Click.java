package com.webtest.jinmingming.yingxiao;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.webtest.core.BaseTest;
import com.webtest.jinmingming.Action;

public class Click extends BaseTest{
	@Test(priority=0)
	public void yushouguanli() throws Exception{
		Action action=new Action(webtest);
		action.login();
		webtest.click("xpath=/html/body/div[3]/div[2]/div[1]/a");
		//营销
		webtest.click("link=营销");
		webtest.click("link=预售管理");
		getDriver().switchTo().frame("workspace");//进文本框
		SoftAssert soft =new SoftAssert();
		AssertJUnit.assertTrue(webtest.isTextPresent("商业用途必须购买正版,使用盗版将追究法律责任"));
		soft.assertAll();
		getDriver().switchTo().defaultContent();//出文本框
	}
	@Test(priority=1)
	public void dapeigouguanli() throws Exception{
		webtest.click("link=搭配购管理");
		getDriver().switchTo().frame("workspace");//进文本框
		SoftAssert soft =new SoftAssert();
		AssertJUnit.assertTrue(webtest.isTextPresent("商业用途必须购买正版,使用盗版将追究法律责任"));
		soft.assertAll();
		getDriver().switchTo().defaultContent();//出文本框
	}
	@Test(priority=2)
	public void kanjiaguanli() throws Exception{
		webtest.click("link=砍价管理");
		getDriver().switchTo().frame("workspace");//进文本框
		SoftAssert soft =new SoftAssert();
		AssertJUnit.assertTrue(webtest.isTextPresent("商业用途必须购买正版,使用盗版将追究法律责任"));
		soft.assertAll();
		getDriver().switchTo().defaultContent();//出文本框
	}
	
	@Test(priority=3)
	public void fenxiangtuan(){
		webtest.click("link=分享团");
		getDriver().switchTo().frame("workspace");//进文本框
		SoftAssert soft =new SoftAssert();
		AssertJUnit.assertTrue(webtest.isTextPresent("商业用途必须购买正版,使用盗版将追究法律责任"));
		soft.assertAll();
		getDriver().switchTo().defaultContent();//出文本框
	}
	@Test(priority=4)
	public void fenxiangtuan2(){
		webtest.click("link=佣金团");		
		getDriver().switchTo().frame("workspace");//进文本框
		SoftAssert soft =new SoftAssert();
		AssertJUnit.assertTrue(webtest.isTextPresent("商业用途必须购买正版,使用盗版将追究法律责任"));
		soft.assertAll();
		getDriver().switchTo().defaultContent();//出文本框
	}
	@Test(priority=5)
	public void fenxiangtuan3(){
		webtest.tapDown();
		webtest.click("link=抽奖团");		
		getDriver().switchTo().frame("workspace");//进文本框
		SoftAssert soft =new SoftAssert();
		AssertJUnit.assertTrue(webtest.isTextPresent("商业用途必须购买正版,使用盗版将追究法律责任"));
		soft.assertAll();
		getDriver().switchTo().defaultContent();//出文本框
	}
	@Test(priority=6)
	public void jilu(){
		webtest.tapDown();
		webtest.tapDown();
		webtest.tapDown();
		webtest.click("link=发放记录");
		getDriver().switchTo().frame("workspace");//进文本框
		SoftAssert soft =new SoftAssert();
		AssertJUnit.assertTrue(webtest.isTextPresent("优惠券发放列表"));
		soft.assertAll();
		getDriver().switchTo().defaultContent();//出文本框
	}
}
