package jinmingming;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.webtest.core.BaseTest;

public class Click extends BaseTest{
	@Test(priority=0,description = "预售管理")
	public void yushouguanli() throws Exception{
		Action action=new Action(webtest);
		action.login();
		//营销
		webtest.click("link=营销");
		webtest.click("link=预售管理");
		getDriver().switchTo().frame("workspace");//进文本框
		SoftAssert soft =new SoftAssert();
		soft.assertTrue(webtest.isTextPresent("商业用途必须购买正版,使用盗版将追究法律责任"));
		soft.assertAll();
		getDriver().switchTo().defaultContent();//出文本框
	}
	@Test(priority=1,description = "搭配购管理")
	public void dapeigouguanli() throws Exception{
		webtest.click("link=搭配购管理");
		getDriver().switchTo().frame("workspace");//进文本框
		SoftAssert soft =new SoftAssert();
		soft.assertTrue(webtest.isTextPresent("商业用途必须购买正版,使用盗版将追究法律责任"));
		soft.assertAll();
		getDriver().switchTo().defaultContent();//出文本框
	}
	@Test(priority=2,description = "砍价管理")
	public void kanjiaguanli() throws Exception{
		webtest.click("link=砍价管理");
		getDriver().switchTo().frame("workspace");//进文本框
		SoftAssert soft =new SoftAssert();
		soft.assertTrue(webtest.isTextPresent("商业用途必须购买正版,使用盗版将追究法律责任"));
		soft.assertAll();
		getDriver().switchTo().defaultContent();//出文本框
	}
	
	@Test(priority=3,description = "分享团")
	public void fenxiangtuan(){
		webtest.click("link=分享团");
		getDriver().switchTo().frame("workspace");//进文本框
		SoftAssert soft =new SoftAssert();
		soft.assertTrue(webtest.isTextPresent("商业用途必须购买正版,使用盗版将追究法律责任"));
		soft.assertAll();
		getDriver().switchTo().defaultContent();//出文本框
	}
	@Test(priority=4,description = "佣金团")
	public void fenxiangtuan2(){
		webtest.click("link=佣金团");		
		getDriver().switchTo().frame("workspace");//进文本框
		SoftAssert soft =new SoftAssert();
		soft.assertTrue(webtest.isTextPresent("商业用途必须购买正版,使用盗版将追究法律责任"));
		soft.assertAll();
		getDriver().switchTo().defaultContent();//出文本框
	}
	@Test(priority=5,description = "抽奖团")
	public void fenxiangtuan3(){
		webtest.tapDown();
		webtest.click("link=抽奖团");		
		getDriver().switchTo().frame("workspace");//进文本框
		SoftAssert soft =new SoftAssert();
		soft.assertTrue(webtest.isTextPresent("商业用途必须购买正版,使用盗版将追究法律责任"));
		soft.assertAll();
		getDriver().switchTo().defaultContent();//出文本框
	}
	@Test(priority=6,description = "发放记录")
	public void jilu(){
		webtest.tapDown();
		webtest.tapDown();
		webtest.tapDown();
		webtest.click("link=发放记录");
		getDriver().switchTo().frame("workspace");//进文本框
		SoftAssert soft =new SoftAssert();
		soft.assertTrue(webtest.isTextPresent("优惠券发放列表"));
		soft.assertAll();
		getDriver().switchTo().defaultContent();//出文本框
	}
}
