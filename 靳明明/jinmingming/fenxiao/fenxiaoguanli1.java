package com.webtest.jinmingming.fenxiao;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.TxtDataProvider;
import com.webtest.jinmingming.Action;

public class fenxiaoguanli1 extends BaseTest{
	@BeforeClass
	public void aaa(){
		Action action=new Action(webtest);
		action.login();
		webtest.click("xpath=/html/body/div[3]/div[2]/div[1]/a");
		//分销
		webtest.click("link=分销");
	}
	@DataProvider(name="data1")
	public Object[][] getDada() throws Exception{
		return new TxtDataProvider().getTxtUser("data//yingxiao//fenxiao1.txt");
	}
	@Test(dataProvider="data1",priority=0)
	public void fenxiaoshangpin(String type,String ass) throws Exception{
		String a = '"'+"link"+"="+type+'"';
		webtest.click(a);
		getDriver().switchTo().frame("workspace");//进文本框
		SoftAssert soft =new SoftAssert();
		AssertJUnit.assertTrue(webtest.isTextPresent(ass));
		soft.assertAll();
		getDriver().switchTo().defaultContent();//出文本框
	}
	@Test(priority=1)
	void fenxiaoshezhi(){
		webtest.click("link=分销设置");
		getDriver().switchTo().frame("workspace");//进文本框
		SoftAssert soft =new SoftAssert();
		AssertJUnit.assertTrue(webtest.isTextPresent("商城设置"));
		soft.assertAll();
		getDriver().switchTo().defaultContent();//出文本框
	}
}
